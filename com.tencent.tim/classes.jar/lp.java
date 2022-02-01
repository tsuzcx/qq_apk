import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class lp
{
  private static final lp[] jdField_a_of_type_ArrayOfLp = ;
  private final lp.b[] jdField_a_of_type_ArrayOfLp$b;
  private final int iT;
  private final int iU;
  
  private lp(int paramInt, int[] paramArrayOfInt, lp.b... paramVarArgs)
  {
    this.iT = paramInt;
    this.jdField_a_of_type_ArrayOfLp$b = paramVarArgs;
    int k = paramVarArgs[0].aP();
    paramArrayOfInt = paramVarArgs[0].a();
    int m = paramArrayOfInt.length;
    int i = 0;
    paramInt = j;
    while (paramInt < m)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      j = paramVarArgs.getCount();
      i += (paramVarArgs.aM() + k) * j;
      paramInt += 1;
    }
    this.iU = i;
  }
  
  public static lp a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return jdField_a_of_type_ArrayOfLp[(paramInt - 1)];
  }
  
  private static lp[] a()
  {
    Object localObject1 = new lp.b(7, new lp.a[] { new lp.a(1, 19) });
    Object localObject2 = new lp.b(10, new lp.a[] { new lp.a(1, 16) });
    Object localObject3 = new lp.b(13, new lp.a[] { new lp.a(1, 13) });
    Object localObject4 = new lp.b(17, new lp.a[] { new lp.a(1, 9) });
    localObject1 = new lp(1, new int[0], new lp.b[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new lp.b(10, new lp.a[] { new lp.a(1, 34) });
    localObject3 = new lp.b(16, new lp.a[] { new lp.a(1, 28) });
    localObject4 = new lp.b(22, new lp.a[] { new lp.a(1, 22) });
    Object localObject5 = new lp.b(28, new lp.a[] { new lp.a(1, 16) });
    localObject2 = new lp(2, new int[] { 6, 18 }, new lp.b[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new lp.b(15, new lp.a[] { new lp.a(1, 55) });
    localObject4 = new lp.b(26, new lp.a[] { new lp.a(1, 44) });
    localObject5 = new lp.b(18, new lp.a[] { new lp.a(2, 17) });
    Object localObject6 = new lp.b(22, new lp.a[] { new lp.a(2, 13) });
    localObject3 = new lp(3, new int[] { 6, 22 }, new lp.b[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new lp.b(20, new lp.a[] { new lp.a(1, 80) });
    localObject5 = new lp.b(18, new lp.a[] { new lp.a(2, 32) });
    localObject6 = new lp.b(26, new lp.a[] { new lp.a(2, 24) });
    Object localObject7 = new lp.b(16, new lp.a[] { new lp.a(4, 9) });
    localObject4 = new lp(4, new int[] { 6, 26 }, new lp.b[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new lp.b(26, new lp.a[] { new lp.a(1, 108) });
    localObject6 = new lp.b(24, new lp.a[] { new lp.a(2, 43) });
    localObject7 = new lp.b(18, new lp.a[] { new lp.a(2, 15), new lp.a(2, 16) });
    Object localObject8 = new lp.b(22, new lp.a[] { new lp.a(2, 11), new lp.a(2, 12) });
    localObject5 = new lp(5, new int[] { 6, 30 }, new lp.b[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new lp.b(18, new lp.a[] { new lp.a(2, 68) });
    localObject7 = new lp.b(16, new lp.a[] { new lp.a(4, 27) });
    localObject8 = new lp.b(24, new lp.a[] { new lp.a(4, 19) });
    Object localObject9 = new lp.b(28, new lp.a[] { new lp.a(4, 15) });
    localObject6 = new lp(6, new int[] { 6, 34 }, new lp.b[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new lp.b(20, new lp.a[] { new lp.a(2, 78) });
    localObject8 = new lp.b(18, new lp.a[] { new lp.a(4, 31) });
    localObject9 = new lp.b(18, new lp.a[] { new lp.a(2, 14), new lp.a(4, 15) });
    Object localObject10 = new lp.b(26, new lp.a[] { new lp.a(4, 13), new lp.a(1, 14) });
    localObject7 = new lp(7, new int[] { 6, 22, 38 }, new lp.b[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new lp.b(24, new lp.a[] { new lp.a(2, 97) });
    localObject9 = new lp.b(22, new lp.a[] { new lp.a(2, 38), new lp.a(2, 39) });
    localObject10 = new lp.b(22, new lp.a[] { new lp.a(4, 18), new lp.a(2, 19) });
    Object localObject11 = new lp.b(26, new lp.a[] { new lp.a(4, 14), new lp.a(2, 15) });
    localObject8 = new lp(8, new int[] { 6, 24, 42 }, new lp.b[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new lp.b(30, new lp.a[] { new lp.a(2, 116) });
    localObject10 = new lp.b(22, new lp.a[] { new lp.a(3, 36), new lp.a(2, 37) });
    localObject11 = new lp.b(20, new lp.a[] { new lp.a(4, 16), new lp.a(4, 17) });
    Object localObject12 = new lp.b(24, new lp.a[] { new lp.a(4, 12), new lp.a(4, 13) });
    localObject9 = new lp(9, new int[] { 6, 26, 46 }, new lp.b[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new lp.b(18, new lp.a[] { new lp.a(2, 68), new lp.a(2, 69) });
    localObject11 = new lp.b(26, new lp.a[] { new lp.a(4, 43), new lp.a(1, 44) });
    localObject12 = new lp.b(24, new lp.a[] { new lp.a(6, 19), new lp.a(2, 20) });
    Object localObject13 = new lp.b(28, new lp.a[] { new lp.a(6, 15), new lp.a(2, 16) });
    localObject10 = new lp(10, new int[] { 6, 28, 50 }, new lp.b[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new lp.b(20, new lp.a[] { new lp.a(4, 81) });
    localObject12 = new lp.b(30, new lp.a[] { new lp.a(1, 50), new lp.a(4, 51) });
    localObject13 = new lp.b(28, new lp.a[] { new lp.a(4, 22), new lp.a(4, 23) });
    Object localObject14 = new lp.b(24, new lp.a[] { new lp.a(3, 12), new lp.a(8, 13) });
    localObject11 = new lp(11, new int[] { 6, 30, 54 }, new lp.b[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new lp.b(24, new lp.a[] { new lp.a(2, 92), new lp.a(2, 93) });
    localObject13 = new lp.b(22, new lp.a[] { new lp.a(6, 36), new lp.a(2, 37) });
    localObject14 = new lp.b(26, new lp.a[] { new lp.a(4, 20), new lp.a(6, 21) });
    Object localObject15 = new lp.b(28, new lp.a[] { new lp.a(7, 14), new lp.a(4, 15) });
    localObject12 = new lp(12, new int[] { 6, 32, 58 }, new lp.b[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new lp.b(26, new lp.a[] { new lp.a(4, 107) });
    localObject14 = new lp.b(22, new lp.a[] { new lp.a(8, 37), new lp.a(1, 38) });
    localObject15 = new lp.b(24, new lp.a[] { new lp.a(8, 20), new lp.a(4, 21) });
    Object localObject16 = new lp.b(22, new lp.a[] { new lp.a(12, 11), new lp.a(4, 12) });
    localObject13 = new lp(13, new int[] { 6, 34, 62 }, new lp.b[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new lp.b(30, new lp.a[] { new lp.a(3, 115), new lp.a(1, 116) });
    localObject15 = new lp.b(24, new lp.a[] { new lp.a(4, 40), new lp.a(5, 41) });
    localObject16 = new lp.b(20, new lp.a[] { new lp.a(11, 16), new lp.a(5, 17) });
    Object localObject17 = new lp.b(24, new lp.a[] { new lp.a(11, 12), new lp.a(5, 13) });
    localObject14 = new lp(14, new int[] { 6, 26, 46, 66 }, new lp.b[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new lp.b(22, new lp.a[] { new lp.a(5, 87), new lp.a(1, 88) });
    localObject16 = new lp.b(24, new lp.a[] { new lp.a(5, 41), new lp.a(5, 42) });
    localObject17 = new lp.b(30, new lp.a[] { new lp.a(5, 24), new lp.a(7, 25) });
    Object localObject18 = new lp.b(24, new lp.a[] { new lp.a(11, 12), new lp.a(7, 13) });
    localObject15 = new lp(15, new int[] { 6, 26, 48, 70 }, new lp.b[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new lp.b(24, new lp.a[] { new lp.a(5, 98), new lp.a(1, 99) });
    localObject17 = new lp.b(28, new lp.a[] { new lp.a(7, 45), new lp.a(3, 46) });
    localObject18 = new lp.b(24, new lp.a[] { new lp.a(15, 19), new lp.a(2, 20) });
    Object localObject19 = new lp.b(30, new lp.a[] { new lp.a(3, 15), new lp.a(13, 16) });
    localObject16 = new lp(16, new int[] { 6, 26, 50, 74 }, new lp.b[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new lp.b(28, new lp.a[] { new lp.a(1, 107), new lp.a(5, 108) });
    localObject18 = new lp.b(28, new lp.a[] { new lp.a(10, 46), new lp.a(1, 47) });
    localObject19 = new lp.b(28, new lp.a[] { new lp.a(1, 22), new lp.a(15, 23) });
    Object localObject20 = new lp.b(28, new lp.a[] { new lp.a(2, 14), new lp.a(17, 15) });
    localObject17 = new lp(17, new int[] { 6, 30, 54, 78 }, new lp.b[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new lp.b(30, new lp.a[] { new lp.a(5, 120), new lp.a(1, 121) });
    localObject19 = new lp.b(26, new lp.a[] { new lp.a(9, 43), new lp.a(4, 44) });
    localObject20 = new lp.b(28, new lp.a[] { new lp.a(17, 22), new lp.a(1, 23) });
    Object localObject21 = new lp.b(28, new lp.a[] { new lp.a(2, 14), new lp.a(19, 15) });
    localObject18 = new lp(18, new int[] { 6, 30, 56, 82 }, new lp.b[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new lp.b(28, new lp.a[] { new lp.a(3, 113), new lp.a(4, 114) });
    localObject20 = new lp.b(26, new lp.a[] { new lp.a(3, 44), new lp.a(11, 45) });
    localObject21 = new lp.b(26, new lp.a[] { new lp.a(17, 21), new lp.a(4, 22) });
    Object localObject22 = new lp.b(26, new lp.a[] { new lp.a(9, 13), new lp.a(16, 14) });
    localObject19 = new lp(19, new int[] { 6, 30, 58, 86 }, new lp.b[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new lp.b(28, new lp.a[] { new lp.a(3, 107), new lp.a(5, 108) });
    localObject21 = new lp.b(26, new lp.a[] { new lp.a(3, 41), new lp.a(13, 42) });
    localObject22 = new lp.b(30, new lp.a[] { new lp.a(15, 24), new lp.a(5, 25) });
    Object localObject23 = new lp.b(28, new lp.a[] { new lp.a(15, 15), new lp.a(10, 16) });
    localObject20 = new lp(20, new int[] { 6, 34, 62, 90 }, new lp.b[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new lp.b(28, new lp.a[] { new lp.a(4, 116), new lp.a(4, 117) });
    localObject22 = new lp.b(26, new lp.a[] { new lp.a(17, 42) });
    localObject23 = new lp.b(28, new lp.a[] { new lp.a(17, 22), new lp.a(6, 23) });
    Object localObject24 = new lp.b(30, new lp.a[] { new lp.a(19, 16), new lp.a(6, 17) });
    localObject21 = new lp(21, new int[] { 6, 28, 50, 72, 94 }, new lp.b[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new lp.b(28, new lp.a[] { new lp.a(2, 111), new lp.a(7, 112) });
    localObject23 = new lp.b(28, new lp.a[] { new lp.a(17, 46) });
    localObject24 = new lp.b(30, new lp.a[] { new lp.a(7, 24), new lp.a(16, 25) });
    Object localObject25 = new lp.b(24, new lp.a[] { new lp.a(34, 13) });
    localObject22 = new lp(22, new int[] { 6, 26, 50, 74, 98 }, new lp.b[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new lp.b(30, new lp.a[] { new lp.a(4, 121), new lp.a(5, 122) });
    localObject24 = new lp.b(28, new lp.a[] { new lp.a(4, 47), new lp.a(14, 48) });
    localObject25 = new lp.b(30, new lp.a[] { new lp.a(11, 24), new lp.a(14, 25) });
    Object localObject26 = new lp.b(30, new lp.a[] { new lp.a(16, 15), new lp.a(14, 16) });
    localObject23 = new lp(23, new int[] { 6, 30, 54, 78, 102 }, new lp.b[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new lp.b(30, new lp.a[] { new lp.a(6, 117), new lp.a(4, 118) });
    localObject25 = new lp.b(28, new lp.a[] { new lp.a(6, 45), new lp.a(14, 46) });
    localObject26 = new lp.b(30, new lp.a[] { new lp.a(11, 24), new lp.a(16, 25) });
    Object localObject27 = new lp.b(30, new lp.a[] { new lp.a(30, 16), new lp.a(2, 17) });
    localObject24 = new lp(24, new int[] { 6, 28, 54, 80, 106 }, new lp.b[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new lp.b(26, new lp.a[] { new lp.a(8, 106), new lp.a(4, 107) });
    localObject26 = new lp.b(28, new lp.a[] { new lp.a(8, 47), new lp.a(13, 48) });
    localObject27 = new lp.b(30, new lp.a[] { new lp.a(7, 24), new lp.a(22, 25) });
    Object localObject28 = new lp.b(30, new lp.a[] { new lp.a(22, 15), new lp.a(13, 16) });
    localObject25 = new lp(25, new int[] { 6, 32, 58, 84, 110 }, new lp.b[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new lp.b(28, new lp.a[] { new lp.a(10, 114), new lp.a(2, 115) });
    localObject27 = new lp.b(28, new lp.a[] { new lp.a(19, 46), new lp.a(4, 47) });
    localObject28 = new lp.b(28, new lp.a[] { new lp.a(28, 22), new lp.a(6, 23) });
    Object localObject29 = new lp.b(30, new lp.a[] { new lp.a(33, 16), new lp.a(4, 17) });
    localObject26 = new lp(26, new int[] { 6, 30, 58, 86, 114 }, new lp.b[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new lp.b(30, new lp.a[] { new lp.a(8, 122), new lp.a(4, 123) });
    localObject28 = new lp.b(28, new lp.a[] { new lp.a(22, 45), new lp.a(3, 46) });
    localObject29 = new lp.b(30, new lp.a[] { new lp.a(8, 23), new lp.a(26, 24) });
    Object localObject30 = new lp.b(30, new lp.a[] { new lp.a(12, 15), new lp.a(28, 16) });
    localObject27 = new lp(27, new int[] { 6, 34, 62, 90, 118 }, new lp.b[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new lp.b(30, new lp.a[] { new lp.a(3, 117), new lp.a(10, 118) });
    localObject29 = new lp.b(28, new lp.a[] { new lp.a(3, 45), new lp.a(23, 46) });
    localObject30 = new lp.b(30, new lp.a[] { new lp.a(4, 24), new lp.a(31, 25) });
    Object localObject31 = new lp.b(30, new lp.a[] { new lp.a(11, 15), new lp.a(31, 16) });
    localObject28 = new lp(28, new int[] { 6, 26, 50, 74, 98, 122 }, new lp.b[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new lp.b(30, new lp.a[] { new lp.a(7, 116), new lp.a(7, 117) });
    localObject30 = new lp.b(28, new lp.a[] { new lp.a(21, 45), new lp.a(7, 46) });
    localObject31 = new lp.b(30, new lp.a[] { new lp.a(1, 23), new lp.a(37, 24) });
    Object localObject32 = new lp.b(30, new lp.a[] { new lp.a(19, 15), new lp.a(26, 16) });
    localObject29 = new lp(29, new int[] { 6, 30, 54, 78, 102, 126 }, new lp.b[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new lp.b(30, new lp.a[] { new lp.a(5, 115), new lp.a(10, 116) });
    localObject31 = new lp.b(28, new lp.a[] { new lp.a(19, 47), new lp.a(10, 48) });
    localObject32 = new lp.b(30, new lp.a[] { new lp.a(15, 24), new lp.a(25, 25) });
    Object localObject33 = new lp.b(30, new lp.a[] { new lp.a(23, 15), new lp.a(25, 16) });
    localObject30 = new lp(30, new int[] { 6, 26, 52, 78, 104, 130 }, new lp.b[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new lp.b(30, new lp.a[] { new lp.a(13, 115), new lp.a(3, 116) });
    localObject32 = new lp.b(28, new lp.a[] { new lp.a(2, 46), new lp.a(29, 47) });
    localObject33 = new lp.b(30, new lp.a[] { new lp.a(42, 24), new lp.a(1, 25) });
    Object localObject34 = new lp.b(30, new lp.a[] { new lp.a(23, 15), new lp.a(28, 16) });
    localObject31 = new lp(31, new int[] { 6, 30, 56, 82, 108, 134 }, new lp.b[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new lp.b(30, new lp.a[] { new lp.a(17, 115) });
    localObject33 = new lp.b(28, new lp.a[] { new lp.a(10, 46), new lp.a(23, 47) });
    localObject34 = new lp.b(30, new lp.a[] { new lp.a(10, 24), new lp.a(35, 25) });
    Object localObject35 = new lp.b(30, new lp.a[] { new lp.a(19, 15), new lp.a(35, 16) });
    localObject32 = new lp(32, new int[] { 6, 34, 60, 86, 112, 138 }, new lp.b[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new lp.b(30, new lp.a[] { new lp.a(17, 115), new lp.a(1, 116) });
    localObject34 = new lp.b(28, new lp.a[] { new lp.a(14, 46), new lp.a(21, 47) });
    localObject35 = new lp.b(30, new lp.a[] { new lp.a(29, 24), new lp.a(19, 25) });
    Object localObject36 = new lp.b(30, new lp.a[] { new lp.a(11, 15), new lp.a(46, 16) });
    localObject33 = new lp(33, new int[] { 6, 30, 58, 86, 114, 142 }, new lp.b[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new lp.b(30, new lp.a[] { new lp.a(13, 115), new lp.a(6, 116) });
    localObject35 = new lp.b(28, new lp.a[] { new lp.a(14, 46), new lp.a(23, 47) });
    localObject36 = new lp.b(30, new lp.a[] { new lp.a(44, 24), new lp.a(7, 25) });
    Object localObject37 = new lp.b(30, new lp.a[] { new lp.a(59, 16), new lp.a(1, 17) });
    localObject34 = new lp(34, new int[] { 6, 34, 62, 90, 118, 146 }, new lp.b[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new lp.b(30, new lp.a[] { new lp.a(12, 121), new lp.a(7, 122) });
    localObject36 = new lp.b(28, new lp.a[] { new lp.a(12, 47), new lp.a(26, 48) });
    localObject37 = new lp.b(30, new lp.a[] { new lp.a(39, 24), new lp.a(14, 25) });
    Object localObject38 = new lp.b(30, new lp.a[] { new lp.a(22, 15), new lp.a(41, 16) });
    localObject35 = new lp(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new lp.b[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new lp.b(30, new lp.a[] { new lp.a(6, 121), new lp.a(14, 122) });
    localObject37 = new lp.b(28, new lp.a[] { new lp.a(6, 47), new lp.a(34, 48) });
    localObject38 = new lp.b(30, new lp.a[] { new lp.a(46, 24), new lp.a(10, 25) });
    Object localObject39 = new lp.b(30, new lp.a[] { new lp.a(2, 15), new lp.a(64, 16) });
    localObject36 = new lp(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new lp.b[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new lp.b(30, new lp.a[] { new lp.a(17, 122), new lp.a(4, 123) });
    localObject38 = new lp.b(28, new lp.a[] { new lp.a(29, 46), new lp.a(14, 47) });
    localObject39 = new lp.b(30, new lp.a[] { new lp.a(49, 24), new lp.a(10, 25) });
    lp.b localb1 = new lp.b(30, new lp.a[] { new lp.a(24, 15), new lp.a(46, 16) });
    localObject37 = new lp(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new lp.b[] { localObject37, localObject38, localObject39, localb1 });
    localObject38 = new lp.b(30, new lp.a[] { new lp.a(4, 122), new lp.a(18, 123) });
    localObject39 = new lp.b(28, new lp.a[] { new lp.a(13, 46), new lp.a(32, 47) });
    localb1 = new lp.b(30, new lp.a[] { new lp.a(48, 24), new lp.a(14, 25) });
    lp.b localb2 = new lp.b(30, new lp.a[] { new lp.a(42, 15), new lp.a(32, 16) });
    localObject38 = new lp(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new lp.b[] { localObject38, localObject39, localb1, localb2 });
    localObject39 = new lp.b(30, new lp.a[] { new lp.a(20, 117), new lp.a(4, 118) });
    localb1 = new lp.b(28, new lp.a[] { new lp.a(40, 47), new lp.a(7, 48) });
    localb2 = new lp.b(30, new lp.a[] { new lp.a(43, 24), new lp.a(22, 25) });
    lp.b localb3 = new lp.b(30, new lp.a[] { new lp.a(10, 15), new lp.a(67, 16) });
    localObject39 = new lp(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new lp.b[] { localObject39, localb1, localb2, localb3 });
    localb1 = new lp.b(30, new lp.a[] { new lp.a(19, 118), new lp.a(6, 119) });
    localb2 = new lp.b(28, new lp.a[] { new lp.a(18, 47), new lp.a(31, 48) });
    localb3 = new lp.b(30, new lp.a[] { new lp.a(34, 24), new lp.a(34, 25) });
    lp.b localb4 = new lp.b(30, new lp.a[] { new lp.a(20, 15), new lp.a(61, 16) });
    return new lp[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new lp(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new lp.b[] { localb1, localb2, localb3, localb4 }) };
  }
  
  public lp.b a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.jdField_a_of_type_ArrayOfLp$b[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int aH()
  {
    return this.iT;
  }
  
  public int aI()
  {
    return this.iU;
  }
  
  public int aJ()
  {
    return this.iT * 4 + 17;
  }
  
  public String toString()
  {
    return String.valueOf(this.iT);
  }
  
  public static final class a
  {
    private final int count;
    private final int iV;
    
    a(int paramInt1, int paramInt2)
    {
      this.count = paramInt1;
      this.iV = paramInt2;
    }
    
    public int aM()
    {
      return this.iV;
    }
    
    public int getCount()
    {
      return this.count;
    }
  }
  
  public static final class b
  {
    private final lp.a[] a;
    private final int iX;
    
    b(int paramInt, lp.a... paramVarArgs)
    {
      this.iX = paramInt;
      this.a = paramVarArgs;
    }
    
    public lp.a[] a()
    {
      return this.a;
    }
    
    public int aP()
    {
      return this.iX;
    }
    
    public int aY()
    {
      int i = 0;
      lp.a[] arrayOfa = this.a;
      int k = arrayOfa.length;
      int j = 0;
      while (i < k)
      {
        j += arrayOfa[i].getCount();
        i += 1;
      }
      return j;
    }
    
    public int ba()
    {
      return this.iX * aY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lp
 * JD-Core Version:    0.7.0.1
 */