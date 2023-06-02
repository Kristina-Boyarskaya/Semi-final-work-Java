class LotteryToys {
    public static void main(String[] args) {
        try {
            FileClear.fileClear();
        } catch (Exception e) {
            System.exit(1);// TODO: handle exception
        }
                                                                              //очистка файла

        Store store = new Store();                                                                 //создание магазина с
        Counter_id counter = new Counter_id(0);                                                   // создание автозаполнение id
        UI ui = new UI();                                                                         //создание интерфейса с пользователем

        Toy car = new Toy(counter.getId(), "машинка", 10, 20);                  //создание игрушек
        Toy transformer = new Toy(counter.getId(), "трансформер", 200, 40);
        Toy ball = new Toy(counter.getId(), "мяч", 200, 40);
        Toy doll = new Toy(counter.getId(), "кукла", 200, 40);
        Toy rubikCube = new Toy(counter.getId(), "кубик рубик", 200, 95);
        Toy soapBubbles = new Toy(counter.getId(), "мыльные пузыри", 10, 10);


        store.addToy(car);                                                                          //добавления игрушек в магазин
        store.addToy(transformer);
        store.addToy(ball);
        store.addToy(doll);
        store.addToy(rubikCube);
        store.addToy(soapBubbles);

        ui.userMenu(store, counter, store.getToys());                                               // работа приложения в пользовательском интерфейсе





    }
}