/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author LozanciZ
 */
public class ProgressIndicatorTableCell<S> extends TableCell<S, Double> {
  public static <S> Callback<TableColumn<S, Double>, TableCell<S, Double>> forTableColumn() {
    return new Callback<TableColumn<S, Double>, TableCell<S, Double>>() {
      @Override
      public TableCell<S, Double> call(TableColumn<S, Double> param) {
        return new ProgressIndicatorTableCell<>();
      }
    };
  }

  private final ProgressIndicator progressIndicator;
  private ObservableValue observable;

  public ProgressIndicatorTableCell() {
    this.getStyleClass().add("progress-indicator-table-cell");

    this.progressIndicator = new ProgressIndicator();
    setGraphic(progressIndicator);
  }

  @Override public void updateItem(Double item, boolean empty) {
    super.updateItem(item, empty);

    if (empty) {
      setGraphic(null);
    } else {
      progressIndicator.progressProperty().unbind();

      observable = getTableColumn().getCellObservableValue(getIndex());
      if (observable != null) {
        progressIndicator.progressProperty().bind(observable);
      } else {
        progressIndicator.setProgress(item);
      }

      setGraphic(progressIndicator);
    }
  }
}
