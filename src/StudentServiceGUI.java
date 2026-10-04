import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentServiceGUI extends JFrame {

    private StudentServiceSystem system;

    private JTextField studentIdField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField contactField;

    private JComboBox<String> serviceTypeBox;
    private JTextArea descriptionArea;

    private JTextField searchField;
    private JComboBox<String> statusBox;

    private JTable requestTable;
    private DefaultTableModel tableModel;

    public StudentServiceGUI() {

        system = new StudentServiceSystem();

        setTitle("Student Service Management System");
        setSize(1100, 700);
        setMinimumSize(new Dimension(950, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();

        setVisible(true);
    }

    private void createGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        setContentPane(mainPanel);

        // =========================
        // FORM PANEL
        // =========================

        JPanel formContainer = new JPanel(new BorderLayout());
        formContainer.setBorder(
                BorderFactory.createTitledBorder("Student Service Request")
        );

        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        studentIdField = new JTextField(20);
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        contactField = new JTextField(20);

        String[] serviceTypes = {
                "Academic Enquiry",
                "IT Support",
                "Assessment Support",
                "General Enquiry"
        };

        serviceTypeBox = new JComboBox<>(serviceTypes);

        descriptionArea = new JTextArea(3, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane descriptionScroll =
                new JScrollPane(descriptionArea);

        // Row 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        formPanel.add(new JLabel("Student ID:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        formPanel.add(studentIdField, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;

        formPanel.add(new JLabel("Student Name:"), gbc);

        gbc.gridx = 3;
        gbc.weightx = 1;

        formPanel.add(nameField, gbc);

        // Row 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        formPanel.add(new JLabel("Email Address:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        formPanel.add(emailField, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;

        formPanel.add(new JLabel("Contact Number:"), gbc);

        gbc.gridx = 3;
        gbc.weightx = 1;

        formPanel.add(contactField, gbc);

        // Row 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        formPanel.add(new JLabel("Service Type:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        formPanel.add(serviceTypeBox, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;

        formPanel.add(new JLabel("Request Description:"), gbc);

        gbc.gridx = 3;
        gbc.weightx = 1;

        formPanel.add(descriptionScroll, gbc);

        // Submit Button
        JButton submitButton =
                new JButton("Submit Request");

        JPanel submitPanel =
                new JPanel(new FlowLayout(FlowLayout.RIGHT));

        submitPanel.add(submitButton);

        formContainer.add(formPanel, BorderLayout.CENTER);
        formContainer.add(submitPanel, BorderLayout.SOUTH);

        mainPanel.add(formContainer, BorderLayout.NORTH);

        // =========================
        // TABLE
        // =========================

        String[] columns = {
                "Request ID",
                "Student ID",
                "Student Name",
                "Service Type",
                "Description",
                "Status"
        };

        tableModel =
                new DefaultTableModel(columns, 0) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        requestTable = new JTable(tableModel);

        requestTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        requestTable.setRowHeight(24);

        requestTable
                .getTableHeader()
                .setReorderingAllowed(false);

        JScrollPane tableScroll =
                new JScrollPane(requestTable);

        tableScroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Submitted Service Requests"
                )
        );

        mainPanel.add(
                tableScroll,
                BorderLayout.CENTER
        );

        // =========================
        // ACTION PANEL
        // =========================

        JPanel actionPanel =
                new JPanel(new GridBagLayout());

        actionPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Request Management"
                )
        );

        GridBagConstraints actionGbc =
                new GridBagConstraints();

        actionGbc.insets =
                new Insets(5, 5, 5, 5);

        actionGbc.fill =
                GridBagConstraints.HORIZONTAL;

        searchField =
                new JTextField(15);

        JButton searchButton =
                new JButton("Search");

        JButton showAllButton =
                new JButton("Show All");

        String[] statuses = {
                "Pending",
                "In Progress",
                "Resolved"
        };

        statusBox =
                new JComboBox<>(statuses);

        JButton updateStatusButton =
                new JButton("Update Status");

        actionGbc.gridx = 0;
        actionGbc.gridy = 0;

        actionPanel.add(
                new JLabel("Student ID / Request ID:"),
                actionGbc
        );

        actionGbc.gridx = 1;
        actionGbc.weightx = 1;

        actionPanel.add(
                searchField,
                actionGbc
        );

        actionGbc.gridx = 2;
        actionGbc.weightx = 0;

        actionPanel.add(
                searchButton,
                actionGbc
        );

        actionGbc.gridx = 3;

        actionPanel.add(
                showAllButton,
                actionGbc
        );

        actionGbc.gridx = 4;

        actionPanel.add(
                new JLabel("New Status:"),
                actionGbc
        );

        actionGbc.gridx = 5;

        actionPanel.add(
                statusBox,
                actionGbc
        );

        actionGbc.gridx = 6;

        actionPanel.add(
                updateStatusButton,
                actionGbc
        );

        mainPanel.add(
                actionPanel,
                BorderLayout.SOUTH
        );

        // =========================
        // BUTTON EVENTS
        // =========================

        submitButton.addActionListener(
                e -> submitRequest()
        );

        searchButton.addActionListener(
                e -> searchRequest()
        );

        showAllButton.addActionListener(
                e -> refreshTable(
                        system.getAllRequests()
                )
        );

        updateStatusButton.addActionListener(
                e -> updateStatus()
        );
    }

    private void submitRequest() {

        String studentId =
                studentIdField
                        .getText()
                        .trim();

        String name =
                nameField
                        .getText()
                        .trim();

        String email =
                emailField
                        .getText()
                        .trim();

        String contact =
                contactField
                        .getText()
                        .trim();

        String serviceType =
                serviceTypeBox
                        .getSelectedItem()
                        .toString();

        String description =
                descriptionArea
                        .getText()
                        .trim();

        // Required field validation
        if (studentId.isEmpty()
                || name.isEmpty()
                || email.isEmpty()
                || contact.isEmpty()
                || description.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all required fields.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Email validation
        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Contact validation
        if (!contact.matches("\\d{7,15}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Contact number must contain 7 to 15 digits.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        Student student =
                new Student(
                        studentId,
                        name,
                        email,
                        contact
                );

        String requestId =
                system.generateRequestId();

        ServiceRequest request =
                new ServiceRequest(
                        requestId,
                        student,
                        serviceType,
                        description,
                        "Pending"
                );

        system.addRequest(request);

        JOptionPane.showMessageDialog(
                this,
                "Request submitted successfully.\n"
                        + "Request ID: "
                        + requestId,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        clearForm();

        refreshTable(
                system.getAllRequests()
        );
    }

    private void searchRequest() {

        String searchValue =
                searchField
                        .getText()
                        .trim();

        if (searchValue.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a Student ID or Request ID.",
                    "Search",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        ServiceRequest request =
                system.searchByRequestId(
                        searchValue
                );

        if (request != null) {

            ArrayList<ServiceRequest> result =
                    new ArrayList<>();

            result.add(request);

            refreshTable(result);

            return;
        }

        ArrayList<ServiceRequest> results =
                system.searchByStudentId(
                        searchValue
                );

        if (results.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No matching request found.",
                    "Search Result",
                    JOptionPane.INFORMATION_MESSAGE
            );

            tableModel.setRowCount(0);

        } else {

            refreshTable(results);
        }
    }

    private void updateStatus() {

        int selectedRow =
                requestTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a request from the table first.",
                    "Status Update",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String requestId =
                tableModel
                        .getValueAt(
                                selectedRow,
                                0
                        )
                        .toString();

        String newStatus =
                statusBox
                        .getSelectedItem()
                        .toString();

        boolean updated =
                system.updateRequestStatus(
                        requestId,
                        newStatus
                );

        if (updated) {

            JOptionPane.showMessageDialog(
                    this,
                    "Request status updated successfully.",
                    "Status Updated",
                    JOptionPane.INFORMATION_MESSAGE
            );

            refreshTable(
                    system.getAllRequests()
            );
        }
    }

    private void refreshTable(
            ArrayList<ServiceRequest> requests) {

        tableModel.setRowCount(0);

        for (ServiceRequest request : requests) {

            Student student =
                    request.getStudent();

            tableModel.addRow(
                    new Object[]{
                            request.getRequestId(),
                            student.getStudentId(),
                            student.getName(),
                            request.getServiceType(),
                            request.getDescription(),
                            request.getStatus()
                    }
            );
        }
    }

    private void clearForm() {

        studentIdField.setText("");
        nameField.setText("");
        emailField.setText("");
        contactField.setText("");
        descriptionArea.setText("");

        serviceTypeBox.setSelectedIndex(0);

        studentIdField.requestFocus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                StudentServiceGUI::new
        );
    }
}