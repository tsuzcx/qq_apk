package com.tencent.qqmail.attachment.util;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.util.HashMap;

public class ImagePagerCache
{
  public static HashMap<String, Integer> fidIndex = null;
  public static final String[] imageCacheKey = { "2/d1114216-9311-4734-b292-12f85d02dfab", "2/db800f50-950f-45a2-8cc1-0445e65756a6", "2/41e4137e-88af-46ec-80af-6585523c7833", "2/f38250d6-c0a6-4789-81c6-afdb1bfa359a", "2/a91797a5-17e8-484d-a3a4-ebc86b4243d0", "2/6641c95b-93b5-497b-87b2-8e42d629091e", "2/a4b2ca75-6504-4377-9d98-57eded221899" };
  public static final String[] imageCookies = { "d1d56258", "e9663a78", "735d1073", "6f2c2dfa", "4f690f0c", "182bb7e0", "f004c58d" };
  public static FtnUI imageFtnUIs = null;
  public static final String[] imageUrls = { "http://xa.ctfs.ftn.qq.com/ftn_handler/3b73ddb08021de6e4779ff6c66373de88fcf6644a306bedb10960c0c4d0998bc744bb6fef0d81dc88d6751232cf0b37d6e36239597bd5851cc29698051644707/Photo_0603_3b.jpg", "http://hz.ftn.qq.com/ftn_handler/6029a92c00e2a2909b1cc7b2db9e16a94072e5ecf0d5936f164d606d2866c6b42b123fd167dbee12a54f843c7945000d9a75311322ce18f0f8a5ca98fe3e99f8/Photo_0523_3b.jpg", "http://cd.ctfs.ftn.qq.com/ftn_handler/48c751107f0461492ab479083248f2df120d16688578e98f126403ab297614f094ab118e8678c4214f50f87b6a1bbecf6fe2cee34835efb3946af4693be8b63e/winwin.jpg", "http://xa.ctfs.ftn.qq.com/ftn_handler/349b048a35825f3240501f0b9cce736ad7b57e6d15d96e84c2b7f85705da5c0837770852c7944aa84f8af66958938247192edd1c1ed8d2ff57aee198a4de23b9/0508_1.jpg", "http://xa.ctfs.ftn.qq.com/ftn_handler/8c13d9a2ed1f6390de9e238413a8c19be079c9b522b948d6bdaea105e6338e0807328de30f35ea70180a4e33e789feffd21c388b9426256a44a1c66749f9d207/FTNAPP.bmp", "http://hz.ftn.qq.com/ftn_handler/cc350d1e0297c51f64753406fe8272e6fbd2e47af4694db265b81653df57c99f924e9ff5df36b1fa46c6c0d91ed9291c5894358129bfb9aef1990fa89bb425a1/11.bmp", "http://xa.ctfs.ftn.qq.com/ftn_handler/cc5c2b7d2e6b26acfe385efd535724ee8fcd9f0781b23baca6d218c94678ab698f6c3d1fd8ba47fa2907a705a39e0c1966f1f9ebb2f363094deebaf4e6d08720/1.bmp " };
  
  public static ImageData fileInfo2ImageData(String paramString, FileInfo paramFileInfo, int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(paramString);
    int i = 0;
    if (localObject != null) {
      i = ((Account)localObject).getId();
    }
    localObject = new ImageData();
    ((ImageData)localObject).setAccountId(i);
    ((ImageData)localObject).setItemPos(paramInt);
    ((ImageData)localObject).setFid(paramFileInfo.fid);
    ((ImageData)localObject).setKey(paramFileInfo.key);
    ((ImageData)localObject).setCode(paramFileInfo.code);
    ((ImageData)localObject).setName(paramFileInfo.filename);
    ((ImageData)localObject).setSuffix(FileUtil.getFileNameSuffix(((ImageData)localObject).getName()));
    ((ImageData)localObject).setDownCookie("");
    ((ImageData)localObject).setThumbUrl(FtnCommonUtils.getThumbUrl(paramString, ((ImageData)localObject).getFid(), "2", "2", i));
    ((ImageData)localObject).setDownUrl(FtnCommonUtils.getThumbUrl(paramString, ((ImageData)localObject).getFid(), "2", "4", i));
    ((ImageData)localObject).setCreateTime(paramFileInfo.createtime);
    ((ImageData)localObject).setDownloadTime(paramFileInfo.downloadtimes);
    ((ImageData)localObject).setExpireTime(paramFileInfo.expiretime);
    long l2 = paramFileInfo.filesize;
    long l1 = l2;
    if (l2 < 0L)
    {
      l1 = Math.pow(2.0D, 31.0D);
      l1 = l2 + l1 + l1;
    }
    ((ImageData)localObject).setSize(l1 + "");
    ((ImageData)localObject).setFileInfo(paramFileInfo);
    return localObject;
  }
  
  private static ImageData ftnUI2ImageData(String paramString, FtnUI paramFtnUI, int paramInt)
  {
    if (paramFtnUI == null) {
      return null;
    }
    return fileInfo2ImageData(paramString, paramFtnUI.get(paramInt), paramInt);
  }
  
  public static ImageData getImageData(String paramString, int paramInt)
  {
    synchronized (imageUrls)
    {
      if (imageFtnUIs == null) {
        return null;
      }
      if ((paramInt >= 0) && (paramInt < imageFtnUIs.getCount()))
      {
        paramString = ftnUI2ImageData(paramString, imageFtnUIs, paramInt);
        return paramString;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.ImagePagerCache
 * JD-Core Version:    0.7.0.1
 */