<script>
	import ChannelMessage from '../controls/ChannelMessage.svelte'
	import DateDivider from '../controls/DateDivider.svelte'
	import MessageEditor from '../controls/MessageEditor.svelte'

  const xxxmessages = [
  ];
</script>

<div>
  channel-conversation

  {#each xxxmessages as msg (msg.client_msg_id)}
    <DateDivider date={msg.ts} />
    <ChannelMessage message={msg} />
  {/each}

  <MessageEditor />
</div>

<style>
div {
}
</style>

