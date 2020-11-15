<script>
	import { channels, directMessages } from "../../stores.js";
	import { route } from '../../routes.js'
</script>

<div>
	<!-- <p>quicklinks</p>
	<ul>
		<li>
			<a href="#"> Mentions &amp; reactions</a>
		</li>
		<li>
			<a href="#"> more...</a>
		</li>
	</ul> -->

	<p>channels</p>
	<ul>
		{#each $channels as channel (channel.title)}
		<li>
			<a href="#" on:click="{() => route.set({path: 'Channel'})}"> {channel.title} </a>
		</li>
		{/each}
  </ul>

	<p>direct messages</p>
	<ul>
		{#each $directMessages as dm (dm.title)}
		<li>
			<a href="#" on:click="{() => route.set({path: 'DirectMessage'})}"> {dm.title} </a>
		</li>
		{/each}
  </ul>
</div>

<style>
	div {
		grid-area: workspace-navigator-area;
		background-color: rgb(63, 14, 64);
		color: rgb(207, 195, 207);
		padding: 1em;
	}
</style>

