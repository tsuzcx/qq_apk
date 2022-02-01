package dov.com.qq.im.ae.data;

import android.text.TextUtils;
import axbq;
import axbr;
import axbu;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AEMaterialConfigParser
{
  private static final String TAG = AEMaterialConfigParser.class.getSimpleName();
  
  public static ArrayList<axbq> ao(String paramString)
    throws AEMaterialConfigParser.AEMaterialConfigParseException
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Object localObject1 = new Gson();
    try
    {
      localObject1 = (GetCategoryMaterialRsp)((Gson)localObject1).fromJson(paramString, GetCategoryMaterialRsp.class);
      if ((localObject1 == null) || (((GetCategoryMaterialRsp)localObject1).Categories == null)) {
        return localArrayList;
      }
    }
    catch (Exception paramString)
    {
      QLog.d(TAG, 4, "###  parseMaterialListFromConfig exception = " + paramString.getMessage());
      throw new AEMaterialConfigParseException("parseMaterialListFromConfig error");
    }
    paramString = new HashMap();
    localObject1 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
    for (;;)
    {
      axbq localaxbq;
      label163:
      Object localObject3;
      axbu localaxbu;
      Map localMap;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MetaCategory)((Iterator)localObject1).next();
        localaxbq = new axbq();
        localaxbq.categoryName = ((MetaCategory)localObject2).name;
        localaxbq.Mm = new ArrayList();
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MetaMaterial)((Iterator)localObject2).next();
            if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (axbr.supportFilament())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor))))) {
              if ((paramString.containsKey(((MetaMaterial)localObject3).id)) && (paramString.get(((MetaMaterial)localObject3).id) != null))
              {
                localObject3 = (axbu)paramString.get(((MetaMaterial)localObject3).id);
                localaxbq.Mm.add(localObject3);
              }
              else
              {
                localaxbu = new axbu();
                localaxbu.iconurl = ((MetaMaterial)localObject3).thumbUrl;
                localMap = ((MetaMaterial)localObject3).additionalFields;
                if (localMap == null) {
                  break;
                }
              }
            }
          }
        }
      }
      try
      {
        localaxbu.kind = Integer.parseInt((String)localMap.get("kind"));
        try
        {
          label357:
          localaxbu.displayType = Integer.parseInt((String)localMap.get("displayType"));
          label377:
          localaxbu.cameraTitle = ((String)localMap.get("qq_camera_top_title"));
          localaxbu.cameraScheme = ((String)localMap.get("qq_camera_scheme"));
          localaxbu.playShowCoverImg = ((String)localMap.get("playshow_cover_img"));
          localaxbu.playShowDisplayText = ((String)localMap.get("playshow_display_text"));
          localaxbu.cTC = ((String)localMap.get("takeSameName"));
          localaxbu.cTD = ((String)localMap.get("showEntry"));
          localaxbu.id = ((MetaMaterial)localObject3).id;
          localaxbu.md5 = ((MetaMaterial)localObject3).packageMd5;
          localaxbu.name = ((MetaMaterial)localObject3).id;
          localaxbu.resurl = ((MetaMaterial)localObject3).packageUrl;
          localaxbq.Mm.add(localaxbu);
          paramString.put(((MetaMaterial)localObject3).id, localaxbu);
          break label163;
          localArrayList.add(localaxbq);
          continue;
          return localArrayList;
        }
        catch (Throwable localThrowable1)
        {
          break label377;
        }
      }
      catch (Throwable localThrowable2)
      {
        break label357;
      }
    }
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString)
  {
    return VideoSDKMaterialParser.parseVideoMaterial(paramString, "params");
  }
  
  public static class AEMaterialConfigParseException
    extends Exception
  {
    public AEMaterialConfigParseException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */