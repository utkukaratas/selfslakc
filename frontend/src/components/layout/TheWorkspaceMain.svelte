<script>
	import ChannelConversation from '../controls/ChannelConversation.svelte'
	export let component = null

</script>

<main>
	workspace main
	<svelte:component this={component}/>

	<ChannelConversation />
</main>

<style>
main {
	border: 1px solid red;
	padding: 1em;
	overflow: scroll;
}
</style>