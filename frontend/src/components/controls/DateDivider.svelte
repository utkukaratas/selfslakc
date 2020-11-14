<script>
  export let date = null;

  $: dateStr = new Date(Number(date))
</script>

<div>
  <hr />
  <detail>{dateStr}</detail>
</div>

<style>
  div {
    /* border: 1px solid red; */
    display: flex;
    position: relative;
    justify-content: center;
    padding: 8px 0;
  }

  hr {
    position: absolute;
    top: 50%;
    left: 0px;
    width: 100%;
    margin: 0;

    background-color: #eee;
    border: 0 none;
    color: rgba(0, 0, 0, 0.08);
    height: 1px;
  }

  detail {
    border: 1px solid rgba(0, 0, 0, 0.08);
    background: #ffffff;
    z-index: 2;
    border-radius: 24px;
    padding: 8px 16px;
  }
</style>
