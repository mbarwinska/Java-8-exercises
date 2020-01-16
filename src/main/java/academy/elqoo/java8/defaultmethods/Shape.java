package academy.elqoo.java8.defaultmethods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

public interface Shape {

    int getXPos();

    int getYPos();


    default void move(int xPos, int yPos) {
        setXPos(xPos);
        setYPos(yPos);
    }

    static void moveXPosWith10(List<AbstractShape> shapes) {
    shapes.forEach(x->x.setXPos(x.getYPos()+10));
    }

     default void notImplementedMethod () {
        throw new NotImplementedException();
     }


    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName() {
        return "";
    }


}
