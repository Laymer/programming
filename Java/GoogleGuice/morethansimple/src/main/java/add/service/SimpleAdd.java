/*
  One implementation of Add interface
 */
package add.service;

public class SimpleAdd implements Add{
    public int add(int a, int b) {
        return a + b;
    }
}