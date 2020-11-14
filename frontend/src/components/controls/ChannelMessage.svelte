<script>
	import Avatar from './Avatar.svelte'

	export let message = null
</script>

<div>
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
div {
  border: 1px solid red;
  display: flex;
  padding: 8px 0;
}
div:hover {
  background: #F8F8F8;
}
</style>