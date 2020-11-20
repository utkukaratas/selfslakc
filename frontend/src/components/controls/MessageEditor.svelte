<script>
  import { createEventDispatcher } from "svelte";

  let value = "";

  const dispatch = createEventDispatcher();

  function handleKeyDown(evt) {
    if (evt.key === "Enter") {
      dispatch("submitMessage", {
        message: value,
      });

      value = ''
      evt.preventDefault() // swallow this one.
    }
  }
</script>

<style>
  .message-editor {
  }
  textarea {
    width: 100%;
    border-radius: 4px;
    border: 1px solid red;
  }
</style>

<div class="message-editor">
  <textarea
    rows="7"
    placeholder="Write..."
    bind:value
    on:keydown={handleKeyDown} />
</div>
