import http from "../http-commons";
class TechnicalTestDataService {
  getAll() {
    return http.get("/ProductsList");
  }
  create(data) {
    return http.post("/AddProducts", data);
  }
}
export default new TechnicalTestDataService();