package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.or;
import com.tencent.map.sdk.a.qk;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int a;
  private final int b;
  
  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    Object localObject1 = getTileUrl(paramInt1, paramInt2, paramInt3);
    Tile localTile = NO_TILE;
    if (localObject1 == null) {
      or.b("TileOverlay", "Tile的请求URL为NULL，返回空瓦块");
    }
    NetResponse localNetResponse;
    do
    {
      while ((localObject1 == null) || (localObject1.length == 0))
      {
        return localTile;
        localNetResponse = requestTileData(((URL)localObject1).toString());
        localObject1 = localObject2;
        if (localNetResponse != null)
        {
          if (!localNetResponse.available()) {
            break;
          }
          localObject1 = localNetResponse.data;
        }
      }
      return new Tile(this.a, this.b, (byte[])localObject1);
      localObject1 = localObject2;
    } while (!(localNetResponse.exception instanceof qk));
    return new Tile(this.a, this.b, null);
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
  
  protected NetResponse requestTileData(String paramString)
  {
    try
    {
      NetResponse localNetResponse = NetManager.getInstance().doGet(paramString);
      return localNetResponse;
    }
    catch (Exception localException)
    {
      or.b("UrlTileProvider getTile failed url:".concat(String.valueOf(paramString)), localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
 * JD-Core Version:    0.7.0.1
 */