import java.util.HashMap;

public class msu
{
  public int aUi;
  public int aUj;
  public boolean anR;
  public boolean anS;
  public long eI;
  public int mSceneType;
  
  public msu(int paramInt)
  {
    this.mSceneType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("mSceneType: ").append(this.mSceneType);
    localStringBuilder.append(", mCurIndexDiff: ").append(this.aUi);
    localStringBuilder.append(", mPreIndexDiff: ").append(this.aUj);
    localStringBuilder.append(", mTimeInterval: ").append(this.eI);
    localStringBuilder.append(", mIsPull: ").append(this.anR);
    localStringBuilder.append(", mIsAutoPlay: ").append(this.anS);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_sceneType", String.valueOf(this.mSceneType));
    localHashMap.put("param_curIndexDiff", String.valueOf(this.aUi));
    localHashMap.put("param_preIndexDiff", String.valueOf(this.aUj));
    localHashMap.put("param_timeInterval", String.valueOf(this.eI));
    localHashMap.put("param_isPull", String.valueOf(this.anR));
    localHashMap.put("param_isAutoPlay", String.valueOf(this.anS));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msu
 * JD-Core Version:    0.7.0.1
 */