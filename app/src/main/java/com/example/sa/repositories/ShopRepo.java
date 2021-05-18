package com.example.sa.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sa.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;
    public LiveData<List<Product>> getProduct(){
        if(mutableProductList == null){
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }
    private void loadProducts(){
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(UUID.randomUUID().toString(),"Blend",200,true,"https://3.bp.blogspot.com/-7A9qrVipedQ/VyNdIMyg-fI/AAAAAAAA6LI/kGw0Eqa17-UxwtCiulVzHTwfHI_9lBzKwCLcB/s800/coffee01_blend.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"American",200,false,"https://4.bp.blogspot.com/-kO9RqwTzvO4/VyNdIYplBdI/AAAAAAAA6LM/k9iW2SiaKpk2JwzIPTkgGP_ryPORi1CnQCLcB/s800/coffee02_american.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Café au Lait",200,true,"https://4.bp.blogspot.com/-EhtAo4Z9TC0/VyNdI6gfNvI/AAAAAAAA6LQ/Bzp3vCXBOH0mpJHnUtby2lf7cFw0pynugCLcB/s800/coffee03_cafeole.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Blend Black",200,true,"https://4.bp.blogspot.com/-4gyo-_td0rg/VyNdJZitpdI/AAAAAAAA6LU/-UOqScW2QMQ2b-zZIGLl-66_PozF53brACLcB/s800/coffee04_blend_black.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Cappuccino",200,true,"https://4.bp.blogspot.com/-N0fGgx3eDTE/VyNdJoeGQtI/AAAAAAAA6Lc/jIUGCRNDAVM6-mhUCRs3hTdovNh9euMzQCLcB/s800/coffee05_cappuccino.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Cafelatte",200,false,"https://1.bp.blogspot.com/-vteKTR2jyec/VyNdKF2_PAI/AAAAAAAA6Lg/IzY1oT2PG3odjBR6lo3GehKJwx2X9fPNgCLcB/s800/coffee06_cafelatte.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Cafe Macchiato",200,true,"https://2.bp.blogspot.com/-M4pnDudAbHk/VyNdKbflzwI/AAAAAAAA6Lk/qzkPe_yZ2pEvol4LDdkItsutyPE9BGQ0gCLcB/s800/coffee07_cafe_macchiato.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Cafe Mocha",200,true,"https://2.bp.blogspot.com/-8wM3hXpj--w/VyNdK1hjDcI/AAAAAAAA6Lo/8KYB16qqmN4o0Q357AsE81w7HBsPtMLBwCLcB/s800/coffee08_cafe_mocha.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Caramel Macchiato",200,true,"https://3.bp.blogspot.com/-kHylKE1mLCk/VyNdLDr7eCI/AAAAAAAA6Ls/v-zPZqo5haghFGKu8KvPo_eYnblQBGmWQCLcB/s800/coffee09_caramel_macchiato.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Iced Coffee",200,true,"https://2.bp.blogspot.com/-YW3x5ABJ9xg/VyNdLpYkldI/AAAAAAAA6Lw/nW_PQMS7ZXs52B8eriRoGphb6bqt7ieRwCLcB/s800/coffee10_iced_coffee.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Iced Milk Coffee",200,true,"https://4.bp.blogspot.com/-UBXK1I6AyLk/VyNdL9WYEwI/AAAAAAAA6L0/bvdsqaU5Gb8dYrixhGgeqtzUS7V4iq7KwCLcB/s800/coffee11_iced_milk_coffee.png"));
        productsList.add(new Product(UUID.randomUUID().toString(),"Espresso",200,true,"https://2.bp.blogspot.com/-Hf9TuhdlZCw/VyNdMA_5qkI/AAAAAAAA6L4/b3BnlTUZv1My3qbYZJohljm-DRSCfljuACLcB/s800/coffee12_espresso.png"));
        //productsList.add(new Product(UUID.randomUUID().toString(),"",200,true,""));

        mutableProductList.setValue(productsList);
    }
}
