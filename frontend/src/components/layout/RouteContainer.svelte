<script>
  import {route, registeredRoutes} from '../../routes'

  $: routeComponent = registeredRoutes[$route.path]
</script>

{#if routeComponent}
  <svelte:component this={routeComponent}/>
{:else}
  <div>empty route.</div>
{/if}

<style>

</style>