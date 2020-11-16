<script>
  import Popup from './Popup.svelte'
  import EmojiSelector from './EmojiSelector.svelte'

  let btnEmojis
  let emojiPopupAt = null

  function handleShowEmojis() {
    const rect = btnEmojis.getBoundingClientRect()
    emojiPopupAt = {
      position: 'absolute',
      left: '0px',
      bottom: rect.height + 4 + 'px'
    }
  }
</script>

<style>
  .message-line-toolbar {
    border: 1px solid lightgray;
    position: relative;
  }
  button {
    background: red;
  }
</style>

<div class="message-line-toolbar">
  <button on:click={handleShowEmojis} bind:this={btnEmojis}>
    :)
  </button>
  <button>
    reply in thread
  </button>
  <button>
    save
  </button>
  <button>
    more
  </button>

  <Popup popupAt={emojiPopupAt}>
    <EmojiSelector />
  </Popup>
</div>