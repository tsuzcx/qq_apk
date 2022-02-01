package com.tencent.qqmail.popularize.businessfilter;

import androidx.annotation.NonNull;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;

public abstract interface PopularizeFilter
{
  @NonNull
  public abstract ArrayList<Popularize> filter(@NonNull ArrayList<Popularize> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.PopularizeFilter
 * JD-Core Version:    0.7.0.1
 */