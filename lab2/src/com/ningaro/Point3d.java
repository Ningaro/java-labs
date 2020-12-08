package com.ningaro;
class Point2d {
    /* координата X */
    private double xCoord;
    /* координата Y */
    private double yCoord;
    /* Конструктор инициализации */
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    /* Конструктор по умолчанию. */
    public Point2d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    /* Возвращение координаты X */
    public double getX () {
        return xCoord;
    }
    /* Возвращение координаты Y */
    public double getY () {
        return yCoord;
    }
    /* Установка значения координаты X. */
    public void setX ( double val) {
        xCoord = val;
    }
    /* Установка значения координаты Y. */
    public void setY ( double val) {
        yCoord = val;
    }
}

public class Point3d extends Point2d {
    //координата Z
    private double zCoord;
    //Конструктор инициализации
    public Point3d(double z){
        zCoord = z;
    }
    //конструктор по умолчанию
    public Point3d(){
        this(0);
    }
    //возвращение координаты Z
    public double getZ(){
        return zCoord;
    }
    //установка значения координаты Z
    public void setZ(double val) {
        zCoord = val;
    }
    //сравнение
    public boolean comparison(Point3d point){
        return this.getZ()==point.getZ()&&this.getY()==point.getY()&&this.getX()==point.getX();
    }
    // Подсчёт расстояния между двумя точками
    public Double distanceTo(Point3d point){
        double distance = Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2) + Math.pow(this.getZ() - point.getZ(), 2));
        return (double) Math.round(distance * 100) / 100;
    }
}