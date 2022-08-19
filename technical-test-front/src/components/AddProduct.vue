<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="nom">Nom</label>
        <input
          type="text"
          class="form-control"
          id="nom"
          required
          v-model="product.nom"
          name="nom"
        />
      </div>
      <div class="form-group">
        <label for="prix">Prix</label>
        <input
          class="form-control"
          id="prix"
          required
          v-model="product.price"
          name="prix"
          type="number"
        />
      </div>
      <button @click="saveProduct" class="btn btn-success">Valider</button>
    </div>
    <div v-else>
      <h4>Produit enregistré !</h4>
      <button class="btn btn-success" @click="newProduct">Ajouter</button>
    </div>
  </div>
</template>
<script>
import TechnicalTestDataService from "../services/TechnicalTestDataService";
export default {
  name: "add-product",
  data() {
    return {
      product: {
        id: null,
        nom: "",
        price: "",
        published: false
      },
      submitted: false
    };
  },
  methods: {

    saveProduct() {
      var data = {
        title: this.product.nom,
        price: this.product.price
      };

      TechnicalTestDataService.create(data)
        .then(response => {
          this.product.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newProduct() {
      this.submitted = false;
      this.product = {};
    }
  }
};
</script>
<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>