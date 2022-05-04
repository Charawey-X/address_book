
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.sql2o.Sql2o;
//import spark.ModelAndView;
//import spark.template.handlebars.HandlebarsTemplateEngine;
//import static spark.Spark.*;
//
//public class App {
//    public static void main(String[] args) {
//        staticFileLocation("/public");
//        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
//        Addresses addresses = new Addresses(sql2o);
//
//        //get: delete all
//        get("/entry/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            addresses.clearAllTasks();
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());
//
//        //get: delete an individual entry
//        get("/entry/:name/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String nameOfAddressToDelete = req.params("name");
//            addresses.findByName(nameOfAddressToDelete);
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());
//
//        //get: show all entries
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Entry> entry = addresses.getAll(); //change
//            model.put("entry", entry);
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //get: show new entry form
//        get("/entry/new", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "entry-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //task: process new task form
//        post("/entry", (req, res) -> { //URL to make new task on POST route
//            Map<String, Object> model = new HashMap<>();
//            String name = req.queryParams("name");
//            Entry newEntry = new Entry(name); //change
//            addresses.add(newEntry);
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());
//
//        //get: show an individual entry
//        get("/entry/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String idOfTaskToFind = req.params("name");
//            Entry foundEntry = addresses.findByName(idOfTaskToFind); //change
//            model.put("entry", foundEntry);
//            return new ModelAndView(model, "entry-detail.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //get: show a form to update a task
//        get("/tasks/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTaskToEdit = Integer.parseInt(req.params("id"));
//            Task editTask = Task.findById(idOfTaskToEdit); //change
//            model.put("editTask", editTask);
//            return new ModelAndView(model, "task-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //task: process a form to update a task
//        post("/tasks/:id", (req, res) -> { //URL to update task on POST route
//            Map<String, Object> model = new HashMap<>();
//            String newContent = req.queryParams("description");
//            int idOfTaskToEdit = Integer.parseInt(req.params("id"));
//            Task editTask = Task.findById(idOfTaskToEdit); //change
//            editTask.update(newContent); //change
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());
//    }
//}

