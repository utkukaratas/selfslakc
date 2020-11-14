<script>
	import Avatar from '../controls/Avatar.svelte'
</script>

<div>
  logo

  <input type="text" placeholder="xxx search input" />

  <Avatar />
</div>

<style>
  div {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 1em 0 1em;
    grid-area: header-area;
    background-color: rgb(53, 13, 54);
    border-bottom: 1px solid rgb(82, 38, 83);
    color: rgb(207, 195, 207);
  }

  input {
    margin: 0;
    background: rgb(73,37,74);
    color: #ffffff;
  }
</style>