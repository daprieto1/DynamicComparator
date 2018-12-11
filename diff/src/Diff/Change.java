/**
 */
package Diff;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Diff.Change#getChangeElement <em>Change Element</em>}</li>
 * </ul>
 *
 * @see Diff.DiffPackage#getChange()
 * @model
 * @generated
 */
public interface Change extends EObject {
	/**
	 * Returns the value of the '<em><b>Change Element</b></em>' attribute.
	 * The literals are from the enumeration {@link Diff.APIElementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Element</em>' attribute.
	 * @see Diff.APIElementType
	 * @see #setChangeElement(APIElementType)
	 * @see Diff.DiffPackage#getChange_ChangeElement()
	 * @model
	 * @generated
	 */
	APIElementType getChangeElement();

	/**
	 * Sets the value of the '{@link Diff.Change#getChangeElement <em>Change Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Element</em>' attribute.
	 * @see Diff.APIElementType
	 * @see #getChangeElement()
	 * @generated
	 */
	void setChangeElement(APIElementType value);

} // Change
