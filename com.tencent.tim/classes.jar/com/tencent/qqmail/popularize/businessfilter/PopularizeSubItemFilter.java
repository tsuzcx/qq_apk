package com.tencent.qqmail.popularize.businessfilter;

import androidx.annotation.NonNull;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import java.util.ArrayList;
import java.util.HashMap;

public abstract interface PopularizeSubItemFilter
{
  @NonNull
  public abstract HashMap<Popularize, ArrayList<PopularizeSubItem>> filter(@NonNull ArrayList<Popularize> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.PopularizeSubItemFilter
 * JD-Core Version:    0.7.0.1
 */