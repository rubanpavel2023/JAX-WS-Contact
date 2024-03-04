package org.example.contact.api;

import jakarta.xml.ws.Service;
import org.example.contact.utils.Constants;
import org.example.server.service.DataService;

import javax.xml.namespace.QName;
import java.net.URL;

public class DataContact {

    private String name;
    private String phone;

    public DataContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String runContact() throws Exception {
        URL url = new URL(Constants.URL);

        QName qname = new QName(
                // Service URI (INFO/img_02.png)
                "http://service.server.example.org/",
                // Service Implementation (INFO/img_02.png)
                "DataServiceImplService"
        );
        Service service = Service.create(url, qname);
        DataService contactService = service.getPort(DataService.class);
        return contactService.getContact(name, phone);
    }
}
