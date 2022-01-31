package android.support.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.Path;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.util.Log;

class VectorDrawableCompat$VPath
{
  int mChangingConfigurations;
  protected PathParser.PathDataNode[] mNodes = null;
  String mPathName;
  
  public VectorDrawableCompat$VPath() {}
  
  public VectorDrawableCompat$VPath(VPath paramVPath)
  {
    this.mPathName = paramVPath.mPathName;
    this.mChangingConfigurations = paramVPath.mChangingConfigurations;
    this.mNodes = PathParser.deepCopyNodes(paramVPath.mNodes);
  }
  
  public void applyTheme(Resources.Theme paramTheme) {}
  
  public boolean canApplyTheme()
  {
    return false;
  }
  
  public PathParser.PathDataNode[] getPathData()
  {
    return this.mNodes;
  }
  
  public String getPathName()
  {
    return this.mPathName;
  }
  
  public boolean isClipPath()
  {
    return false;
  }
  
  public String nodesToString(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    String str = " ";
    int i = 0;
    while (i < paramArrayOfPathDataNode.length)
    {
      str = str + paramArrayOfPathDataNode[i].mType + ":";
      float[] arrayOfFloat = paramArrayOfPathDataNode[i].mParams;
      int j = 0;
      while (j < arrayOfFloat.length)
      {
        str = str + arrayOfFloat[j] + ",";
        j += 1;
      }
      i += 1;
    }
    return str;
  }
  
  public void printVPath(int paramInt)
  {
    String str = "";
    int i = 0;
    while (i < paramInt)
    {
      str = str + "    ";
      i += 1;
    }
    Log.v("VectorDrawableCompat", str + "current path is :" + this.mPathName + " pathData is " + nodesToString(this.mNodes));
  }
  
  public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    if (!PathParser.canMorph(this.mNodes, paramArrayOfPathDataNode))
    {
      this.mNodes = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
      return;
    }
    PathParser.updateNodes(this.mNodes, paramArrayOfPathDataNode);
  }
  
  public void toPath(Path paramPath)
  {
    paramPath.reset();
    if (this.mNodes != null) {
      PathParser.PathDataNode.nodesToPath(this.mNodes, paramPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VPath
 * JD-Core Version:    0.7.0.1
 */