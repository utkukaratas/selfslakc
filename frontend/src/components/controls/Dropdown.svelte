<script>
  let self = null
  let shouldShow = false

  function handleClick() {
    shouldShow = true
  }

  // xxx: impl. ondestroy
  document.addEventListener('click', function(e) {
    if (!self.contains(e.target)) {
      shouldShow = false
    }
  });
</script>

<style>
  .dropdown {
    position: relative;
    display: inline-block;
  }

  .dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 1;
  }

  .show {
    display: block;
  }
</style>

<div bind:this={self} class="dropdown" on:click="{handleClick}">
  <slot>
  </slot>
  <div class="dropdown-content" class:show="{shouldShow}">
    <slot name="content">
    </slot>
  </div>
</div>
