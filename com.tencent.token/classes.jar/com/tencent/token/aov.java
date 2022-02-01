package com.tencent.token;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

public final class aov
{
  final List<aoq<?, Path>> a;
  final List<aou<Integer>> b;
  final List<apv> c;
  
  public aov(List<apv> paramList)
  {
    this.c = paramList;
    this.a = new ArrayList(paramList.size());
    this.b = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      this.a.add(((apv)paramList.get(i)).b.c());
      apj localapj = ((apv)paramList.get(i)).c;
      this.b.add(localapj.a());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aov
 * JD-Core Version:    0.7.0.1
 */