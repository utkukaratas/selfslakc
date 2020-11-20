<script>
  import { tick } from 'svelte';
  import ChannelMessage from "../controls/ChannelMessage.svelte";
  import DateDivider from "../controls/DateDivider.svelte";
  import MessageEditor from "../controls/MessageEditor.svelte";
  import Popup from "../controls/Popup.svelte";
  import MessageLineToolbar from "../controls/MessageLineToolbar.svelte";

  let messages = [
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
    {
      id: Math.random(),
      user: {
        username: "xxx",
      },
      ts: new Date(),
      text: Math.random(),
    },
  ];
  let showMessageToolbarAt = false;
  let eom = null;

  function handleMessageHover(evt) {
    const rect = evt.target.getBoundingClientRect();
    // showMessageToolbarAt = [rect.x, rect.y];
    console.log(rect);
    showMessageToolbarAt = {
      top: rect.top + "px",
      right: 30 + "px",
    };

    // 'absolute' does not work as popup here is not a child of channel-message
    // showMessageToolbarAt = {
    //   position: 'absolute',
    //   right: '0px',
    //   top: '0px'
    // }
  }

  async function handleSubmitMessage(evt) {
    console.log(evt.detail.message);

    // create new message object
    messages = [
      ...messages,
      {
        id: Math.random(),
        user: {
          username: "xxx",
        },
        ts: new Date(),
        text: evt.detail.message,
      },
    ];

    // wait for dom update and then scroll
    await tick();
    eom.scrollIntoView({
      behavior: 'smooth',
      block: 'end'
    })
  }
</script>

<style>
  .channel-conversation {
    display: flex;
    flex-direction: column;
    height: 100%;
    border: 3px solid lime;
  }
  .message-container {
    flex: 1;
    overflow: scroll;
  }
  .editor-container {
    flex: initial;
  }
  .end-of-messages {
    background: green;
    height: 5px;
  }
</style>

<div class="channel-conversation">
  <div class="message-container">
    {#each messages as msg (msg.id)}
      <DateDivider date={msg.ts} />
      <ChannelMessage message={msg} on:mouseenter={handleMessageHover} />
    {/each}
    <div class="end-of-messages" bind:this={eom}> </div>
  </div>
  <div class="editor-container">
    <MessageEditor on:submitMessage={handleSubmitMessage} />
  </div>
  <Popup popupAt={showMessageToolbarAt}>
    <MessageLineToolbar />
  </Popup>
</div>
