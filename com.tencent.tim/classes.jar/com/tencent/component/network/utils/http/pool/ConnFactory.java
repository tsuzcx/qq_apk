package com.tencent.component.network.utils.http.pool;

import java.io.IOException;

public abstract interface ConnFactory<T, C>
{
  public abstract C create(T paramT)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.ConnFactory
 * JD-Core Version:    0.7.0.1
 */