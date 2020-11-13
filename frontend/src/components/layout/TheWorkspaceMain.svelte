<script>
	export let component = null
</script>

<main>
	workspace main
	<svelte:component this={component}/>
</main>

<style>
main {
	border: 1px solid red;
	padding: 1em;
}
</style>