package android.support.graphics.drawable;

import android.animation.TypeEvaluator;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;

class AnimatorInflaterCompat$PathDataEvaluator
  implements TypeEvaluator
{
  private PathParser.PathDataNode[] mNodeArray;
  
  private AnimatorInflaterCompat$PathDataEvaluator() {}
  
  AnimatorInflaterCompat$PathDataEvaluator(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    this.mNodeArray = paramArrayOfPathDataNode;
  }
  
  public PathParser.PathDataNode[] evaluate(float paramFloat, PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    if (!PathParser.canMorph(paramArrayOfPathDataNode1, paramArrayOfPathDataNode2)) {
      throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
    if ((this.mNodeArray == null) || (!PathParser.canMorph(this.mNodeArray, paramArrayOfPathDataNode1))) {
      this.mNodeArray = PathParser.deepCopyNodes(paramArrayOfPathDataNode1);
    }
    int i = 0;
    while (i < paramArrayOfPathDataNode1.length)
    {
      this.mNodeArray[i].interpolatePathDataNode(paramArrayOfPathDataNode1[i], paramArrayOfPathDataNode2[i], paramFloat);
      i += 1;
    }
    return this.mNodeArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator
 * JD-Core Version:    0.7.0.1
 */