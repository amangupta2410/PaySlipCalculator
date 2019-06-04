/*
 * package com.payslip;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.MockitoJUnitRunner;
 * 
 * import static org.hamcrest.CoreMatchers.is; import static
 * org.junit.Assert.assertThat; import static org.mockito.Mockito.when;
 * 
 * import java.io.ByteArrayInputStream; import java.io.ByteArrayOutputStream;
 * import java.io.InputStream; import java.io.PrintStream; import
 * java.nio.charset.Charset; import java.util.ArrayList; import java.util.List;
 * import java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * @RunWith(MockitoJUnitRunner.class) public class PaySlipApplicationTest {
 * 
 * @InjectMocks private PaySlipApplication paySlipApplication;
 * 
 * @Mock private PaySlipCalculator paySlipCalculator;
 * 
 * @Test public void testProducesPayslipDetailsBasedOnEmployeeInput() {
 * when(paySlipCalculator.generate(new Employee("David", "Rudd", 60050, 9f,
 * "01 March � 31 March"))) .thenReturn(new
 * PaySlipDetails("01 March � 31 March", "David", "Rudd", 5004, 922, 4082,
 * 450));
 * 
 * ByteArrayInputStream inputStream =
 * createStringInputStream("David","Rudd",60050,9f,"01 March - 31 March");
 * ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
 * 
 * paySlipApplication.generatePayslip(inputStream, new
 * PrintStream(byteArrayOutputStream));
 * 
 * assertThat(byteArrayOutputStream.toString(),
 * is("David,Rudd,01 March � 31 March,5004,922,4082,450\n")); }
 * 
 * @Test public void testHandlesMultiLineInput() {
 * when(paySlipCalculator.generate(new Employee("David", "Rudd", 60050, 9f,
 * "01 March � 31 March"))) .thenReturn(new
 * PaySlipDetails("01 March � 31 March", "David", "Rudd", 5004, 922, 4082,
 * 450)); when(paySlipCalculator.generate(new Employee("Ryan", "Chen", 120000,
 * 10f, "01 March � 31 March"))) .thenReturn(new
 * PaySlipDetails("01 March � 31 March", "Ryan", "Chen", 10000, 2696, 7304,
 * 1000));
 * 
 * ByteArrayInputStream inputStream =
 * createStringInputStream("David","Rudd",60050,9.0f,"01 March - 31 March");
 * ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
 * 
 * paySlipApplication.generatePayslip(inputStream, new
 * PrintStream(byteArrayOutputStream));
 * 
 * assertThat(byteArrayOutputStream.toString(), is(
 * "David,Rudd,01 March � 31 March,5004,922,4082,450\nRyan,Chen,01 March � 31 March,10000,2696,7304,1000\n"
 * )); }
 * 
 * @Test public void testHandlesEmptyInput() { ByteArrayInputStream inputStream
 * = createStringInputStream("", "", 0, 0, null); ByteArrayOutputStream
 * byteArrayOutputStream = new ByteArrayOutputStream();
 * 
 * paySlipApplication.generatePayslip(inputStream, new
 * PrintStream(byteArrayOutputStream));
 * 
 * assertThat(byteArrayOutputStream.toString(), is("")); }
 * 
 * @Test(expected = IllegalArgumentException.class) public void
 * testThrowsExceptionWhenCsvFormatIsWrong() { ByteArrayInputStream inputStream
 * = createStringInputStream(null, null, 0, 0, null); ByteArrayOutputStream
 * byteArrayOutputStream = new ByteArrayOutputStream();
 * 
 * paySlipApplication.generatePayslip(inputStream, new
 * PrintStream(byteArrayOutputStream)); }
 * 
 * //private ByteArrayInputStream createStringInputStream(String[]...
 * inputLines) private ByteArrayInputStream createStringInputStream(String
 * string, String string2, double i, float j, String string3) { List<Employee>
 * inputLines=new ArrayList<Employee>(); // return new
 * ByteArrayInputStream(inputLines.stream().collect(Collectors.joining("\n")).
 * getBytes(Charset.defaultCharset())); return new
 * ByteArrayInputStream(inputLines.stream().collect(Collectors.joining(","))
 * getBytes(Charset.defaultCharset()));
 * 
 * 
 * collect(Collectors.joining("\n")).getBytes(Charset.defaultCharset())); } }
 */