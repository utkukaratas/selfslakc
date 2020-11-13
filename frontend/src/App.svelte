<script>
	import { channels, directMessages } from "./stores.js";

	import TheHeader from "./components/layout/TheHeader.svelte";
	import TheWorkspaceSelector from "./components/layout/TheWorkspaceSelector.svelte";
	import TheWorkspaceNavigator from "./components/layout/TheWorkspaceNavigator.svelte";
	import TheWorkspaceMain from "./components/layout/TheWorkspaceMain.svelte";

	channels.set([
		{ title: "xxx" },
		{ title: "yyy" },
		{ title: "zzz" }
	]);

	directMessages.set([
		{ title: "utku" },
		{ title: "ensar" },
		{ title: "esma" }
	]);
</script>

<main>
	<TheHeader />
	<TheWorkspaceSelector />
	<TheWorkspaceNavigator />
	<TheWorkspaceMain />
</main>

<style>
	main {
		height: 100%;
		width: 100%;
		display: grid;
		/* border: 1px solid red; */

		/* grid-gap: 10px; */
		grid-template-rows: 45px auto;
		grid-template-columns: 70px 270px auto;
		grid-template-areas: "header-area header-area header-area" "workspace-selector-area workspace-navigator-area .";

		background-color: #fbfbfb;
	}
</style>
