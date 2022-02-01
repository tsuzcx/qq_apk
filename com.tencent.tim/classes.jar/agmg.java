import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.FileExtInfo;
import cooperation.weiyun.channel.pb.WeiyunPB.FileItem;
import cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class agmg
  implements awpw<WeiyunPB.LibInfoListGetMsgRsp>
{
  agmg(agmf paramagmf, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.LibInfoListGetMsgRsp paramLibInfoListGetMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    }
    agmf.a(this.b).a().b(false, 31, new Object[] { Integer.valueOf(paramInt), paramString, this.bIf });
  }
  
  public void a(WeiyunPB.LibInfoListGetMsgRsp paramLibInfoListGetMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onSucceed, num[" + paramLibInfoListGetMsgRsp.FileItem_items.size() + "]");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramLibInfoListGetMsgRsp.FileItem_items.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeiyunPB.FileItem)((Iterator)localObject1).next();
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.mtime = ((WeiyunPB.FileItem)localObject2).file_mtime.get();
      localWeiYunFileInfo.nFileSize = ((WeiyunPB.FileItem)localObject2).file_size.get();
      localWeiYunFileInfo.cYi = ((WeiyunPB.FileItem)localObject2).ext_info.from_source.get();
      localWeiYunFileInfo.bIk = ((WeiyunPB.FileItem)localObject2).file_id.get();
      localWeiYunFileInfo.dirKey = awrh.g(((WeiyunPB.FileItem)localObject2).pdir_key.get());
      localWeiYunFileInfo.strFileName = ((WeiyunPB.FileItem)localObject2).filename.get();
      localWeiYunFileInfo.cookieName = ((WeiyunPB.FileItem)localObject2).ext_info.cookie_name.get();
      localWeiYunFileInfo.cookieValue = ((WeiyunPB.FileItem)localObject2).ext_info.cookie_value.get();
      localWeiYunFileInfo.encodeUrl = ((WeiyunPB.FileItem)localObject2).ext_info.thumb_url.get();
      localWeiYunFileInfo.hostName = ((WeiyunPB.FileItem)localObject2).ext_info.weiyun_host.get();
      localWeiYunFileInfo.port = ((WeiyunPB.FileItem)localObject2).ext_info.weiyun_port.get();
      localWeiYunFileInfo.md5 = awrh.g(((WeiyunPB.FileItem)localObject2).file_md5.get());
      localWeiYunFileInfo.sha = awrh.g(((WeiyunPB.FileItem)localObject2).file_sha.get());
      if (!agmf.a(this.b).containsKey(localWeiYunFileInfo.bIk))
      {
        agmf.a(this.b).put(localWeiYunFileInfo.bIk, localWeiYunFileInfo);
        localArrayList.add(localWeiYunFileInfo);
      }
    }
    localObject1 = agmf.a(this.b).a();
    Object localObject2 = this.bIf;
    if (paramLibInfoListGetMsgRsp.finish_flag.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((agkh)localObject1).b(true, 31, new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(paramLibInfoListGetMsgRsp.FileItem_items.size()), paramLibInfoListGetMsgRsp.server_version.get(), localArrayList, Integer.valueOf(agmf.a(this.b)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agmg
 * JD-Core Version:    0.7.0.1
 */