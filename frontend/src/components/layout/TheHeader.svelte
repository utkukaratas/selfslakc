<script>
  import Dropdown from '../controls/Dropdown.svelte'
	import Avatar from '../controls/Avatar.svelte'
</script>

<header>
  logo

  <input type="text" placeholder="xxx search input" />

  <Dropdown>
    <Avatar />
    <div slot="content">
      <ul>
        <li>settings</li>
        <li>sign out</li>
      </ul>
    </div>
  </Dropdown>
</header>

<style>
  header {
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