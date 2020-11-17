<script>
  import ChannelMessage from "../controls/ChannelMessage.svelte";
  import DateDivider from "../controls/DateDivider.svelte";
  import MessageEditor from "../controls/MessageEditor.svelte";
  import Popup from "../controls/Popup.svelte";
  import MessageLineToolbar from "../controls/MessageLineToolbar.svelte";

  const messages = []
  let showMessageToolbarAt = false;

  function handleMessageHover(evt) {
    const rect = evt.target.getBoundingClientRect();
    // showMessageToolbarAt = [rect.x, rect.y];
    console.log(rect)
    showMessageToolbarAt = {
      top: rect.top + 'px',
      right: 30 + 'px'
    }

    // 'absolute' does not work as popup here is not a child of channel-message
    // showMessageToolbarAt = {
    //   position: 'absolute',
    //   right: '0px',
    //   top: '0px'
    // }
  }
</script>

<style>
  .channel-conversation {
  }
</style>

<div class="channel-conversation">
  {#each messages as msg (msg.client_msg_id)}
    <DateDivider date={msg.ts} />
    <ChannelMessage message={msg} on:mouseenter={handleMessageHover} />
  {/each}

  <MessageEditor />

  <Popup popupAt={showMessageToolbarAt}>
    <MessageLineToolbar />
  </Popup>
</div>
