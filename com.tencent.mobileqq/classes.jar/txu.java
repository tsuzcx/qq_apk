import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class txu
  extends twt
{
  private VidListPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo;
  private two jdField_a_of_type_Two;
  
  public txu(VidListPlayInfo paramVidListPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo = paramVidListPlayInfo;
    this.jdField_a_of_type_Two = new two("vidList");
  }
  
  public List<twv> a(List<two> paramList)
  {
    return null;
  }
  
  public twr a()
  {
    return new twr(this.jdField_a_of_type_Two, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVideoFeedId);
  }
  
  public void a() {}
  
  public void a(int paramInt, twu paramtwu)
  {
    ArrayList localArrayList = new ArrayList();
    twp localtwp = new twp(this.jdField_a_of_type_Two);
    localArrayList.add(localtwp);
    localtwp.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.size();
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.size())
    {
      if (paramInt < i) {}
      for (String str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(paramInt);; str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(i - 1))
      {
        localtwp.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.get(paramInt), str);
        paramInt += 1;
        break;
      }
    }
    paramtwu.b(new ErrorMessage(), localArrayList, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txu
 * JD-Core Version:    0.7.0.1
 */