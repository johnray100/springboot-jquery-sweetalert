package jay.springboot_jquery_sweetalert.Controller;

import jay.springboot_jquery_sweetalert.Model.Product;
import jay.springboot_jquery_sweetalert.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // list all products
    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "views/list-product";
    }

    // add product
    @GetMapping("/products/create")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "views/create-product";
    }

    // save product
    @PostMapping("/saveProduct")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // edit product
    @GetMapping("/edit-{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "views/update-product";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }

    // delete product
    @GetMapping("/delete-{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }


    // other code option
//    @PostMapping
//    public String saveProduct(@ModelAttribute("product") Product product) {
//        productService.saveProduct(product);
//        return "views/product";
//    }

//    @GetMapping("/edit/{id}")
//    public String showEditProductForm(@PathVariable Long id, Model model) {
//        model.addAttribute("product", productService.getProductById(id));
//        return "views/edit";
//    }

//    @PostMapping("/update/{id}")
//    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
//        productService.saveProduct(product);
//        return "redirect:/products";
//    }

}
