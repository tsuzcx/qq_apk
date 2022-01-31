package com.qzone.utils.http.pool;

import java.io.IOException;

public abstract interface ConnFactory<T, C>
{
  public abstract C create(T paramT)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.pool.ConnFactory
 * JD-Core Version:    0.7.0.1
 */