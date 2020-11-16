<script>
  export let popupAt = false
  let self
  let css

  $: {
    //
    // generate inline css to apply to the dom elm.
    //
    if (Array.isArray(popupAt)) {
      const [x, y] = popupAt
      css = `display: block; top: ${y}px; left: ${x}px;`
    } else if (!popupAt) {
      css = `display: none;`
    } else if (popupAt.getBoundingClientRect) {
      // so this is a dom element
      // just show at top left of the element.
      const rect = popupAt.getBoundingClientRect()
      const {x, y} = rect
      css = `display: block; top: ${y}px; left: ${x}px;`
    } else if (typeof popupAt === 'object' && popupAt !== null) {
      // in case an object is given treat it as css props
      const cssDecls = Object
        .entries(popupAt)
        .map(([x, y]) => `${x}: ${y}`)
        .join(';')
      css = `display: block; ${cssDecls}`
    } else {
      console.error('huh?')
    }
  }

  // console.log(555, popupAt, css)
</script>

<style>
.popup {
  display: none;
  position: fixed;
  z-index: 999;
}
</style>

<div class="popup" bind:this={self} style={css}>
  <slot></slot>
</div>