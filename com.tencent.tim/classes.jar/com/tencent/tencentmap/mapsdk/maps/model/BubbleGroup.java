package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.kg;
import com.tencent.map.sdk.a.kt;
import java.util.List;

public class BubbleGroup
{
  public static final int INVALID_BUBBLE_ID = -1;
  private kg a;
  
  public BubbleGroup(kg paramkg)
  {
    this.a = paramkg;
  }
  
  public int addBubble(BubbleOptions paramBubbleOptions)
  {
    if (this.a == null) {}
    kg localkg;
    do
    {
      return -1;
      localkg = this.a;
    } while (localkg.a == null);
    return localkg.a.a(paramBubbleOptions, localkg);
  }
  
  public void clearBubbleGroup()
  {
    if (this.a == null) {
      return;
    }
    this.a.a();
  }
  
  public boolean containsBubble(int paramInt)
  {
    if (this.a == null) {}
    kg localkg;
    do
    {
      return false;
      localkg = this.a;
    } while (localkg.a == null);
    return localkg.a.b(paramInt);
  }
  
  public List<Integer> getBubbleIds()
  {
    if (this.a == null) {}
    kg localkg;
    do
    {
      return null;
      localkg = this.a;
    } while (localkg.a == null);
    return localkg.a.b();
  }
  
  public boolean remove(int paramInt)
  {
    if (this.a == null) {}
    kg localkg;
    do
    {
      return false;
      localkg = this.a;
    } while (localkg.a == null);
    return localkg.a.a(paramInt);
  }
  
  public boolean updateBubble(int paramInt, BubbleOptions paramBubbleOptions)
  {
    if ((this.a == null) || (paramBubbleOptions == null)) {}
    kg localkg;
    do
    {
      return false;
      localkg = this.a;
    } while ((localkg.a == null) || (paramBubbleOptions == null));
    return localkg.a.a(paramInt, paramBubbleOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BubbleGroup
 * JD-Core Version:    0.7.0.1
 */