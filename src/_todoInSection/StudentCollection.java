package _todoInSection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Student;

/**
 * StudentCollection is a collection class that keeps track of all our students.
 * 
 * @author Jorge Vergara, Rick Mercer, and Jeremy Mowery (jermowery@email.arizona.edu)
 *    
 */
public class StudentCollection  implements TableModel{

  private List<Student> theStudents;

  /**
   * The constructor for a StudentCollection. Initializes the list of
   * students.
   */
  public StudentCollection() {
    theStudents = new ArrayList<Student>();
    setUpDefaultList();
  }

  /**
   * Initializes the list with a few hard-coded students
   */
  private void setUpDefaultList() {
    theStudents.add(new Student("Kim", "Computer Science", 4.0, 23));
    theStudents.add(new Student("Chris", "Computer Science", 4.0, 23));
    theStudents.add(new Student("Devon", "Math", 2.7, 21));
    theStudents.add(new Student("Ashley", "Biology", 3.29, 27));
    theStudents.add(new Student("Taylor", "Economics", 3.9, 25));
    theStudents.add(new Student("Chris", "Economics", 3.8, 19));
    theStudents.add(new Student("Dakota", "Psychology", 1.99, 22));
  }
 
  public int size() {
    return theStudents.size();
  }

  public void add(Student newStudent) {
    theStudents.add(newStudent);
  }

  public Student get(int index) {
    return theStudents.get(index);
  }

  public Student getFirstStudentWithName(String name) {
    for (int index = 0; index < size(); index++) {
      if (name.equals(theStudents.get(index).getName()))
        return theStudents.get(index);
    }
    return null; // not found
  }

@Override
public void addTableModelListener(TableModelListener arg0) {
}

@Override
public Class<?> getColumnClass(int arg0) {
	return Object.class;
}

@Override
public int getColumnCount() {
	return 4;
}

@Override
public String getColumnName(int arg0) {
	if(arg0 == 0){
		return "Name";
	}
	if(arg0 == 1){
		return "Major";
	}
	if(arg0 == 2){
		return "GPA";
	}
	if(arg0 == 3){
		return "Age";
	}
	return null;
}

@Override
public int getRowCount() {
	return size();
}

@Override
public Object getValueAt(int arg0, int arg1) {
	Student tmp = get(arg0);
	
	if(arg1 == 0){
		return tmp.getName();
	}
	if(arg1 == 1){
		return tmp.getMajor();
	}
	if(arg1 == 2){
		return tmp.getGPA();
	}
	if(arg1 == 3){
		return tmp.getAge();
	}
	return 0;
}

@Override
public boolean isCellEditable(int arg0, int arg1) {
	return false;
}

@Override
public void removeTableModelListener(TableModelListener arg0) {
}

@Override
public void setValueAt(Object arg0, int arg1, int arg2) {
}

}
