package org.hj77.datamanager.api.controller.dto;



public record ClientDTO (String id){

    public String getId() {
        return this.id;
    }
}
