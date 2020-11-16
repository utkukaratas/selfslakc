<script>
	import Avatar from './Avatar.svelte'

	export let message = null
</script>

<div class="channel-message" on:mouseenter>
  <Avatar />
  <article>
    <header>
      <b>{message.user.username}</b> <span>{message.ts}</span>
    </header>
    <pre>
      {message.text}
    </pre>
  </article>
</div>

<style>
.channel-message {
  border: 1px solid red;
  display: flex;
  position: relative;
  padding: 8px 0;
}
.channel-message:hover {
  background: #F8F8F8;
}
</style>