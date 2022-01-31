package com.tencent.mobileqq.activity.photo;

import com.tencent.image.URLDrawable;
import java.net.URL;
import java.util.LinkedList;

public class PhotoListBitmapRecycle
{
  LinkedList a = new LinkedList();
  LinkedList b = new LinkedList();
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.a.size()) {
        break label59;
      }
      URLDrawable localURLDrawable = (URLDrawable)this.a.get(i);
      if ((localURLDrawable.getStatus() == 1) && (localURLDrawable.getURL().equals(paramURLDrawable.getURL()))) {
        break;
      }
      i += 1;
    }
    label59:
    if (paramURLDrawable.getStatus() == 1) {
      paramURLDrawable.getCurrDrawable();
    }
    for (;;)
    {
      URLDrawable.removeMemoryCacheByUrl(paramURLDrawable.getURL().toString());
      return;
      paramURLDrawable.cancelDownload();
    }
  }
  
  public void a(int paramInt)
  {
    while ((this.b.size() > 0) && (paramInt >= ((Integer)this.b.get(0)).intValue()))
    {
      this.b.removeFirst();
      a((URLDrawable)this.a.removeFirst());
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    int k = 0;
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= this.b.size()) {
          break label97;
        }
        if (paramInt <= ((Integer)this.b.get(j)).intValue()) {
          break;
        }
        j += 1;
      }
      if (paramInt < ((Integer)this.b.get(j)).intValue())
      {
        this.b.add(j, Integer.valueOf(paramInt));
        this.a.add(paramURLDrawable);
      }
      for (int i = 1; i == 0; i = 1)
      {
        label97:
        this.a.add(paramURLDrawable);
        this.b.add(Integer.valueOf(paramInt));
        return;
        this.a.remove(j);
        this.a.add(j, paramURLDrawable);
      }
    }
  }
  
  public void b(int paramInt)
  {
    while ((this.b.size() > 0) && (paramInt <= ((Integer)this.b.get(this.b.size() - 1)).intValue()))
    {
      this.b.removeLast();
      a((URLDrawable)this.a.removeLast());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListBitmapRecycle
 * JD-Core Version:    0.7.0.1
 */