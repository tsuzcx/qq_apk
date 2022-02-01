import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public abstract class ayvi
{
  public void a(azan.a parama, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoState", 2, "[@] notify called eventId=" + paramInt);
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if ((paramObject instanceof AudioCapture)) {
      switch (paramInt)
      {
      }
    }
    label304:
    label332:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localRMVideoStateMgr.cyk();
            return;
          } while (!(paramObject instanceof anim.c));
          QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM eventId" + paramInt + ", rmStateMgr:" + localRMVideoStateMgr);
          if (localRMVideoStateMgr == null) {
            break label392;
          }
          switch (paramInt)
          {
          default: 
            return;
          case 2: 
            if ((paramVarArgs == null) || (localRMVideoStateMgr.a == null)) {
              break label332;
            }
            if (!(paramVarArgs[0] instanceof anij.b)) {
              break label304;
            }
            paramObject = (anij.b)paramVarArgs[0];
            try
            {
              localRMVideoStateMgr.a.gs(paramObject.width, paramObject.height);
              QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[success]");
              return;
            }
            catch (NullPointerException paramObject)
            {
              paramObject.printStackTrace();
            }
          }
        } while (localRMVideoStateMgr == null);
        QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM:rmStateMgr=" + localRMVideoStateMgr + " viewST=" + localRMVideoStateMgr.a);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("faceuu", 2, "RMVideoState viewST:" + localRMVideoStateMgr.a);
        }
      } while (localRMVideoStateMgr.a == null);
      localRMVideoStateMgr.a.cwA();
      return;
      QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM: no CustomSize obj[0]=" + paramVarArgs[0]);
      return;
      QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[2]:obj=" + paramVarArgs);
    } while (localRMVideoStateMgr == null);
    QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[2]:viewST=" + localRMVideoStateMgr.a);
    return;
    label392:
    QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM  rmStateMgr==null");
  }
  
  public abstract void initState();
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct) {}
  
  public void onPause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvi
 * JD-Core Version:    0.7.0.1
 */