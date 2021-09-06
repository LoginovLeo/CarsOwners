package ru.loginovleo.carsowners.dto;


public class AutomobileDto {
        private Integer id;

        private String brand;

        private String model;

        private int power;

        private Double price;



        public AutomobileDto(Integer id, String brand, String model, int power, Double price) {
                this.id = id;
                this.brand = brand;
                this.model = model;
                this.power = power;
                this.price = price;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getBrand() {
                return brand;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public int getPower() {
                return power;
        }

        public void setPower(int power) {
                this.power = power;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }
}
