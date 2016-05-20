package org.foo.training.snake.core;

import java.util.ArrayList;

/**
 * Created by afedorenchik on 5/19/16.
 */
public class Snake {
    private SnakeHead head;
    private ArrayList<SnakeSegment> segments;
    private Direction d;

    // Snake consist of head and segments
    public Snake(Integer x, Integer y, Direction d) {
        this.d = d;
        head = new SnakeHead(x, y);
        segments.add(new SnakeSegment(head.getX() - 1, head.getY()));
        segments.add(new SnakeSegment(head.getX() - 2, head.getY()));
        segments.add(new SnakeSegment(head.getX() - 3, head.getY()));
    }
}
