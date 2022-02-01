package com.tencent.lbssearch.object.param;

import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class TranslateParam
  implements ParamObject
{
  private List<LatLng> a;
  private CoordType b = CoordType.STANDARD;
  
  public TranslateParam addLocation(LatLng paramLatLng)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramLatLng);
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if ((this.a != null) && (this.a.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.a.size())
      {
        String str = "";
        if (i != 0) {
          str = "" + ";";
        }
        localStringBuilder.append(str + ((LatLng)this.a.get(i)).latitude + "," + ((LatLng)this.a.get(i)).longitude);
        i += 1;
      }
      localfn.b("locations", localStringBuilder.toString());
    }
    localfn.b("type", this.b.ordinal());
    return localfn;
  }
  
  public boolean checkParams()
  {
    return this.a != null;
  }
  
  public TranslateParam coordType(CoordType paramCoordType)
  {
    this.b = paramCoordType;
    return this;
  }
  
  public TranslateParam coord_type(CoordTypeEnum paramCoordTypeEnum)
  {
    coordType(paramCoordTypeEnum.coordType);
    return this;
  }
  
  public TranslateParam locations(LatLng... paramVarArgs)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.a.add(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public static enum CoordType
  {
    static
    {
      GPS = new CoordType("GPS", 1);
      SOGOU = new CoordType("SOGOU", 2);
      BAIDU = new CoordType("BAIDU", 3);
      MAPBAR = new CoordType("MAPBAR", 4);
      STANDARD = new CoordType("STANDARD", 5);
    }
    
    private CoordType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.TranslateParam
 * JD-Core Version:    0.7.0.1
 */