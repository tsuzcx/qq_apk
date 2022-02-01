package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.map.sdk.a.dh;
import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SearchParam
  implements ParamObject
{
  private String a;
  private Boundary b;
  private String c;
  private boolean d = true;
  private int e = -1;
  private int f = 1;
  
  public SearchParam() {}
  
  public SearchParam(String paramString, Boundary paramBoundary)
  {
    this.a = paramString;
    this.b = paramBoundary;
  }
  
  public SearchParam boundary(Boundary paramBoundary)
  {
    this.b = paramBoundary;
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (!TextUtils.isEmpty(this.a)) {
      localfn.b("keyword", this.a);
    }
    if (this.b != null) {
      localfn.b("boundary", this.b.toString());
    }
    if (!TextUtils.isEmpty(this.c)) {
      localfn.b("filter", this.c);
    }
    if (this.d) {}
    for (String str = "_distance";; str = "_distance desc")
    {
      localfn.b("orderby", str);
      if (this.e > 0) {
        localfn.b("page_size", String.valueOf(this.e));
      }
      if (this.f > 0) {
        localfn.b("page_index", String.valueOf(this.f));
      }
      return localfn;
    }
  }
  
  public boolean checkParams()
  {
    return (!TextUtils.isEmpty(this.a)) && (this.b != null);
  }
  
  public SearchParam filter(String... paramVarArgs)
  {
    this.c = dh.a(paramVarArgs);
    return this;
  }
  
  public SearchParam keyword(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public SearchParam orderby(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public SearchParam pageIndex(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public SearchParam pageSize(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public SearchParam page_index(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public SearchParam page_size(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public SearchParam region(Region paramRegion)
  {
    return this;
  }
  
  static abstract interface Boundary
  {
    public abstract String toString();
  }
  
  public static class Nearby
    implements SearchParam.Boundary
  {
    private LatLng a;
    private int b;
    private boolean c = true;
    
    public Nearby() {}
    
    public Nearby(LatLng paramLatLng, int paramInt)
    {
      this.a = paramLatLng;
      this.b = paramInt;
    }
    
    public Nearby autoExtend(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }
    
    public Nearby point(LatLng paramLatLng)
    {
      this.a = paramLatLng;
      return this;
    }
    
    public Nearby r(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("nearby(").append(this.a.latitude).append(",").append(this.a.longitude).append(",").append(this.b).append(",");
      if (this.c) {}
      for (int i = 1;; i = 0) {
        return i + ")";
      }
    }
  }
  
  public static class Rectangle
    implements SearchParam.Boundary
  {
    private LatLng a;
    private LatLng b;
    
    public Rectangle() {}
    
    public Rectangle(LatLng paramLatLng1, LatLng paramLatLng2)
    {
      this.a = paramLatLng1;
      this.b = paramLatLng2;
    }
    
    public Rectangle point(LatLng paramLatLng1, LatLng paramLatLng2)
    {
      this.a = paramLatLng1;
      this.b = paramLatLng2;
      return this;
    }
    
    public String toString()
    {
      return "rectangle(" + this.a.latitude + "," + this.a.longitude + "," + this.b.latitude + "," + this.b.longitude + ")";
    }
  }
  
  public static class Region
    implements SearchParam.Boundary
  {
    private String a;
    private boolean b = false;
    private LatLng c;
    
    public Region() {}
    
    public Region(String paramString)
    {
      this.a = paramString;
    }
    
    public Region autoExtend(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }
    
    public Region center(LatLng paramLatLng)
    {
      this.c = paramLatLng;
      return this;
    }
    
    public Region poi(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public String toString()
    {
      Object localObject = new StringBuilder("region(").append(this.a).append(",");
      int i;
      StringBuilder localStringBuilder;
      if (this.b)
      {
        i = 1;
        localStringBuilder = ((StringBuilder)localObject).append(i);
        if (this.c == null) {
          break label101;
        }
      }
      label101:
      for (localObject = "," + this.c.latitude + "," + this.c.longitude;; localObject = "")
      {
        return (String)localObject + ")";
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SearchParam
 * JD-Core Version:    0.7.0.1
 */