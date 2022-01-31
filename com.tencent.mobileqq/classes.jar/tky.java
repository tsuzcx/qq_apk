import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class tky
  extends tjx
{
  private VidListPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo;
  private tjs jdField_a_of_type_Tjs;
  
  public tky(VidListPlayInfo paramVidListPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo = paramVidListPlayInfo;
    this.jdField_a_of_type_Tjs = new tjs("vidList");
  }
  
  public List<tjz> a(List<tjs> paramList)
  {
    return null;
  }
  
  public tjv a()
  {
    return new tjv(this.jdField_a_of_type_Tjs, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVideoFeedId);
  }
  
  public void a() {}
  
  public void a(int paramInt, tjy paramtjy)
  {
    ArrayList localArrayList = new ArrayList();
    tjt localtjt = new tjt(this.jdField_a_of_type_Tjs);
    localArrayList.add(localtjt);
    localtjt.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.size();
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.size())
    {
      if (paramInt < i) {}
      for (String str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(paramInt);; str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(i - 1))
      {
        localtjt.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.get(paramInt), str);
        paramInt += 1;
        break;
      }
    }
    paramtjy.b(new ErrorMessage(), localArrayList, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tky
 * JD-Core Version:    0.7.0.1
 */