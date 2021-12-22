package ru.zapashnii.rickandmorty.ui.fields

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zapashnii.rickandmorty.R
import ru.zapashnii.rickandmorty.const.CHARACTER
import ru.zapashnii.rickandmorty.const.EPISODE
import ru.zapashnii.rickandmorty.const.LOCATION
import ru.zapashnii.rickandmorty.ui.theme.Black2
import ru.zapashnii.rickandmorty.ui.theme.Grey1

/**
 * Нижня панель навигации
 *
 * @param layoutId                  префикс идентификатора элемента в его родительском элементе
 * @param onTabBarClick             нажатие на карточку
 * @param defaultColor              цвет иконки без фокуса
 * @param focusColor                цвет иконки на которой фокус
 */
@Composable
fun BottomBar(
    layoutId: String = "BottomBar",
    onTabBarClick: (nameTitle: String) -> Unit = {},
    defaultColor: Color = Black2,
    focusColor: Color = Grey1,
    selectedItem: String = EPISODE
) {
    BottomNavigation(
        elevation = 12.dp,
        modifier = Modifier.layoutId("${layoutId}Parent")
    ) {
        BottomNavigationItem(
            modifier = Modifier.layoutId("${layoutId}Home"),
            icon = { Icon(Icons.Default.Computer, EPISODE) },
            selected = selectedItem == EPISODE,
            onClick = { onTabBarClick(EPISODE) },
            label = {
                Text(
                    modifier = Modifier.layoutId("${layoutId}Home"),
                    text = stringResource(id = R.string.episode)
                )
            },
            alwaysShowLabel = false,
            selectedContentColor = focusColor,
            unselectedContentColor = defaultColor,
        )

        BottomNavigationItem(
            modifier = Modifier.layoutId("${layoutId}Search"),
            icon = { Icon(Icons.Default.PermIdentity, CHARACTER) },
            selected = selectedItem == CHARACTER,
            onClick = { onTabBarClick(CHARACTER) },
            alwaysShowLabel = false,
            label = {
                Text(
                    modifier = Modifier.layoutId("${layoutId}Search"),
                    text = stringResource(id = R.string.character)
                )
            },
            selectedContentColor = focusColor,
            unselectedContentColor = defaultColor,
        )

        BottomNavigationItem(
            modifier = Modifier.layoutId("${layoutId}Settings"),
            icon = { Icon(Icons.Default.LocationOn, LOCATION) },
            selected = selectedItem == LOCATION,
            onClick = { onTabBarClick(LOCATION) },
            alwaysShowLabel = false,
            label = {
                Text(
                    modifier = Modifier.layoutId("${layoutId}Settings"),
                    text = stringResource(id = R.string.location)
                )
            },
            selectedContentColor = focusColor,
            unselectedContentColor = defaultColor,
        )
    }
}