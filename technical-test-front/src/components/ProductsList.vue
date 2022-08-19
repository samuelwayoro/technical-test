<template>
  <div class="list row">
    <div class="col-md-6">
      <h4>Products List</h4>
      <ul class="list-group">
        <li class="list-group-item" v-for="(product, index) in products" :key="index">
          {{ product.nom }}
        </li>
      </ul>
    </div>
  </div>
</template>


<script>
import TechnicalTestDataService from "../services/TechnicalTestDataService";

export default {
  name: "products-list",
  data() {
    return {
      products: [],
      currentIndex: -1,
      nom: ""
    };
  },
  methods: {
    listOfProducts() {
      TechnicalTestDataService.getAll()
        .then(response => {
          this.products = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
    
  },
  mounted() {
    this.listOfProducts();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>